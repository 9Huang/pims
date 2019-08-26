package com.huang.pims.common.utils;

import com.github.pagehelper.PageInfo;
import com.huang.pims.common.model.TableListPagination;

public class ModelConvertor {

    private ModelConvertor() {
        super();
    }

    public static TableListPagination toTableListPagination(PageInfo pageInfo) {
        return new TableListPagination(pageInfo.getSize(), pageInfo.getPageSize(), pageInfo.getPageNum());
    }


}
