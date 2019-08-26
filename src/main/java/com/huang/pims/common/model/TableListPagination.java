package com.huang.pims.common.model;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class TableListPagination implements Serializable {

    private static final long serialVersionUID = -1876860389388147437L;

    private Integer total;

    private Integer pageSize;

    private Integer current;

}
