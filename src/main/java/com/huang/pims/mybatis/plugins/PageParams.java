package com.huang.pims.mybatis.plugins;

import lombok.Data;

@Data
public class PageParams {

    /**
     * 当前页码
     */
    private Integer pageNo;

    /**
     * 每页记录数
     */
    private Integer pageSize;

    /**
     * 总共记录数
     */
    private Integer totalSize;

    /**
     * 总共页数
     */
    private Integer totalPage;

    /**
     * 是否使用该分页对象参数
     */
    private Boolean useOrNot;

    /**
     * 是否检查pageNo的有效性
     * 如果checkPageNoOrNot=true且pageNo>totalPage，则抛出异常
     */
    private Boolean checkPageNoOrNot;

    /**
     * 是否清除掉order by后面的语句
     */
    private Boolean clearOrderByOrNot;

}
