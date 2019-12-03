package com.huang.pims.address.region.sync.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class CityDTO extends RegionalDTO {
    private static final long serialVersionUID = -4874348402278580183L;

    @JSONField(name = "citycode")
    private String cityCode;

}
