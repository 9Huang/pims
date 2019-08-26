package com.huang.pims.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class TableListParams implements Serializable {

    private static final long serialVersionUID = 3950973775030809138L;

    private String sorter;

    private Integer currentPage;

    private Integer pageSize;



}
