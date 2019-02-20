package com.huang.pims.web;

import com.huang.pims.beans.base.PersonalBaseInfo;
import com.huang.pims.service.BaseInfoService;
import io.lettuce.core.RedisCommandExecutionException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 记录个人信息
 * @author huangj
 */
@Slf4j
@Controller
@RequestMapping("/recordPersonalInfo/")
public class RecordPersonalInfoController {

    @Autowired
    private BaseInfoService baseInfoService;

    @Autowired
    private RedisTemplate redisTemplate;

    @ResponseBody
    @RequestMapping("getPersonalInfoById/{id}")
    public PersonalBaseInfo getPersonalInfoById(@PathVariable Integer id) {
        log.info("getPersonalInfoById() id=?", id);
        PersonalBaseInfo personalBaseInfo = baseInfoService.queryById(id);
        return personalBaseInfo;
    }

    @ResponseBody
    @RequestMapping("getPersonalInfoBy")
    public PersonalBaseInfo getPersonalInfoBy(@RequestParam("id") Integer id) {
        log.info("getPersonalInfoBy() id=?", id);
        PersonalBaseInfo personalBaseInfo = baseInfoService.queryById(id);
        return personalBaseInfo;
    }

    public void showString() {

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        // 设值
        redisTemplate.opsForValue().set("stringKey","stringValue");
        // 获取值的长度
        long stringSize = redisTemplate.opsForValue().size("stringKey");
        System.out.println("stringSize="+stringSize);
        String stringValue = (String) redisTemplate.opsForValue().get("stringKey");
        System.out.println("stringValue="+stringValue);
        String stringRangeValue = redisTemplate.opsForValue().get("stringKey", 0, 3);
        System.out.println("stringRangeValue="+stringRangeValue);
        String oldStringValue = (String) redisTemplate.opsForValue().getAndSet("stringKey", "newStringValue");
        System.out.println("oldStringValue="+oldStringValue);
        int newStringValueLength = redisTemplate.opsForValue().append("stringKey", "_append");
        System.out.println("newStringValueLength="+newStringValueLength);

        redisTemplate.opsForValue().set("intKey", "10");
        Long addIntValue = redisTemplate.opsForValue().increment("intKey");
        System.out.println("addIntValue="+addIntValue);
        Long addOneIntValue = redisTemplate.opsForValue().increment("intKey", 1);
        System.out.println("addOneIntValue="+addOneIntValue);
        Long decrIntValue = redisTemplate.opsForValue().decrement("intKey");
        System.out.println("decrIntValue="+decrIntValue);
        Long decrOneIntValue = redisTemplate.opsForValue().decrement("intKey", 1);
        System.out.println("decrOneIntValue="+decrOneIntValue);

        redisTemplate.opsForValue().set("floatKey","10.1");
        Double addOneFloatValue = redisTemplate.opsForValue().increment("floatKey", 1.1);
        System.out.println("addOneFloatValue="+addOneFloatValue);
        // 下面三种操作会抛出RedisCommandExecutionException
//        Long addFloatValue = redisTemplate.opsForValue().increment("floatKey");
//        System.out.println("addFloatValue="+addFloatValue);
//        Long decrFloatValue = redisTemplate.opsForValue().decrement("floatKey");
//        System.out.println("decrFloatValue="+decrFloatValue);
//        Long decrOneFloatValue = redisTemplate.opsForValue().decrement("floatKey", 1);
//        System.out.println("decrOneFloatValue="+decrOneFloatValue);

        // 结果如下
//        stringSize=11
//        stringValue=stringValue
//        stringRangeValue=stri
//        oldStringValue=stringValue
//        newStringValueLength=21
//        addIntValue=11
//        addOneIntValue=12
//        decrIntValue=11
//        decrOneIntValue=10
//        addOneFloatValue=11.2
    }

}
