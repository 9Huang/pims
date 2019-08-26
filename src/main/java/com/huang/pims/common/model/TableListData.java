package com.huang.pims.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class TableListData implements Serializable {

    private static final long serialVersionUID = 5925249018352131958L;

    private List<TableListItem> list;

    private TableListPagination pagination;

}
