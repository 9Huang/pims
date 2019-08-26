package com.huang.pims.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 防重复提交
 */
@Target(value = {ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AvoidDuplicateSubmissions {
    /**
     * 超时限制，指定多长时间内不可重复提交，单位是毫秒
     * 默认设置为5分钟
     * @return
     */
    long timeout() default 300000;
}
