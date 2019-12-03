package com.huang.pims.address.region.sync.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
public enum RegionalLevelEnum {

    PROVINCE("province", "省"),

    CITY("city", "市"),

    AREA("area", "区");

    private final String code;

    private final String desc;

    private static final Map<String, RegionalLevelEnum> enumMap = new HashMap<>(5);

    static {
        for (RegionalLevelEnum levelEnum : RegionalLevelEnum.values()) {
            enumMap.put(levelEnum.getCode(), levelEnum);
        }
    }

    public static RegionalLevelEnum getByCode(String code) {
        if (Objects.isNull(code) || "".equals(code.trim())) {
            return null;
        }
        return enumMap.get(code);
    }

}
