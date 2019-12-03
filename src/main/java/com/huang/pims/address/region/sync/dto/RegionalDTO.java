package com.huang.pims.address.region.sync.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RegionalDTO implements Serializable {

    private static final long serialVersionUID = -2873220601705157620L;

    private String adcode;

    private String name;

    private String center;

    private String level;

    private List<RegionalDTO> districts;

}
