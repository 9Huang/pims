package com.huang.pims.base.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 数据库记录状态枚举类
 */
public enum DataStatusEnum {

    VALID("1", "有效"), INVALID("0", "无效");

    private String code;

    private String desc;

    DataStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    private static Map<String, DataStatusEnum> recordStatusMap = new HashMap<>(2);

    static {
        for (DataStatusEnum recordStatus : DataStatusEnum.values()) {
            recordStatusMap.put(recordStatus.getCode(), recordStatus);
        }
    }

    public static DataStatusEnum getByCode(String code) {
        return recordStatusMap.get(code);
    }

    public static String getDescByCode(String code) {
        DataStatusEnum recordStatus = getByCode(code);
        return Objects.isNull(recordStatus) ? null : recordStatus.getDesc();
    }

}
