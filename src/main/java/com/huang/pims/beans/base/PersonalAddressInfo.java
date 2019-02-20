package com.huang.pims.beans.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PersonalAddressInfo {

    private Long id;

    private Long countryId;

    private Long provinceId;

    private Long cityId;

    private Long areaId;

    private String detailedAddress;

    private String postalCode;

    private String contactName;

    private Long contactUserId;

    private Integer mobileArea;

    private String mobile;

}