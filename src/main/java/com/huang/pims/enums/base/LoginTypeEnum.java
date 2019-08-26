package com.huang.pims.enums.base;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录方式枚举类
 *
 * @author huang
 */
@Getter
public enum LoginTypeEnum {

    /**
     * 账号登录
     */
    LOGIN_BY_ACCOUNT(0,"账号登录"),

    /**
     * 手机登录
     */
    LOGIN_BY_PHONE(1,"手机登录"),

    /**
     * 邮箱登录
     */
    LOGIN_BY_EMAIL(2,"邮箱登录");

    private static final Map<Integer, LoginTypeEnum> loginTypeEnumMap = new HashMap<>(3);

    static {
        for (LoginTypeEnum loginTypeEnum : LoginTypeEnum.values()) {
            loginTypeEnumMap.put(loginTypeEnum.getCode(), loginTypeEnum);
        }
    }

    private int code;

    private String desc;

    LoginTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
