package com.huang.pims.address.region.sync.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class ProvinceDTO extends RegionalDTO {

    private static final long serialVersionUID = -6661422589371599457L;

    @JSONField(name = "citycode")
    private List<String> cityCode;

}
