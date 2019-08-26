package com.huang.pims.enums.base;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 性别枚举类
 * @author huang
 */
@Getter
public enum SexEnum {

    MALE(0, "女"), FEMALE(1,"男");

    private int code;

    private String desc;

    private static Map<Integer, SexEnum> sexEnumMap = new HashMap<>(2);

    static {
        for(SexEnum sexEnum : SexEnum.values()) {
            sexEnumMap.put(sexEnum.getCode(), sexEnum);
        }
    }

    SexEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static SexEnum getByCode(int code) {
        return sexEnumMap.get(code);
    }

    public static String getDescByCode(int code) {
        SexEnum sexEnum = getByCode(code);
        return Objects.isNull(sexEnum) ? null : sexEnum.getDesc();
    }

    @Override
    public String toString() {
        return new StringBuilder().append("super.toString()=").append(super.toString())
                .append("\n").append(",name=").append(this.name())
                .append("\n").append(",ordinal=").append(this.ordinal())
                .append("\n").append(",code=").append(this.code)
                .append("\n").append(",desc=").append(this.desc).toString();
    }
}
