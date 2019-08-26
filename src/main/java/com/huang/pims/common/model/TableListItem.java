package com.huang.pims.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class TableListItem implements Serializable {

    private static final long serialVersionUID = 4697345009858369120L;

    private String key;

    private Boolean disabled = Boolean.FALSE;

}
