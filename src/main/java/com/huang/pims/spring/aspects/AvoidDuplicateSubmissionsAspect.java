package com.huang.pims.spring.aspects;

import com.huang.pims.annotations.AvoidDuplicateSubmissions;
import com.huang.pims.utils.NetworkUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 使用AOP实现防重复提交
 */
@Aspect
@Component
public class AvoidDuplicateSubmissionsAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(AvoidDuplicateSubmissionsAspect.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Around(value = "@annotation(com.huang.pims.annotations.AvoidDuplicateSubmissions)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpServletRequest request  = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        // 获取客户端IP
        String ip = NetworkUtil.getIpAddress(request);
        // 获取方法
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        // 组装key
        String className = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String ipKey = String.format("%s#%s", className, methodName);
        int classMethodHashCode = Objects.hashCode(ipKey);
        String key = String.format("%s_%d",ip,classMethodHashCode);
        LOGGER.info("ipKey={}, classMethodHashCode={}, key={}", ipKey, classMethodHashCode, key);
        // 检查AvoidDuplicateSubmissions注解的参数值
        AvoidDuplicateSubmissions annotation = method.getAnnotation(AvoidDuplicateSubmissions.class);
        long timeout = annotation.timeout();
        if (timeout < 0L) {
            timeout = 5*60*1000;
        }
        // 检查redis中是否存在key
        String value = (String) redisTemplate.opsForValue().get(key);
        if (StringUtils.isBlank(value)) {
            // 不存在，则将该key添加到redis数据库中
            redisTemplate.opsForValue().set(key, UUID.randomUUID().toString(), timeout, TimeUnit.MILLISECONDS);
            // 执行目标方法，返回结果
            return proceedingJoinPoint.proceed();
        } else {
            // 存在则表明是重复请求，直接返回
            return "Duplicate Request";
        }

    }


}
