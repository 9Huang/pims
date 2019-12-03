package com.huang.pims.address.region.sync.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class AreaDTO extends RegionalDTO {

    private static final long serialVersionUID = -5169512748667325737L;

    @JSONField(name = "citycode")
    private String cityCode;
}
