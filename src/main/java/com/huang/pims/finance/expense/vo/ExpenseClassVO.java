package com.huang.pims.finance.expense.vo;


import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * (ExpenseClass)实体类
 *
 * @author huangj
 * @since 2019-06-24 22:34:08
 */
@Data
public class ExpenseClassVO implements Serializable {
    
    private static final long serialVersionUID = -26557798465773532L;
    
    /**
     * 主键ID
     */
    private Long id;
    
    /**
     * 支出类型
     */
    private String expenseClassName;
    
    /**
     * 支出类型描述
     */
    private String expenseClassDesc;
    
    /**
     * 是否有效  1-有效 0-无效
     */
    private String status;
    
    /**
     * 创建人
     */
    private Long createdBy;
    
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
    
    /**
     * 修改人
     */
    private Long modifiedBy;
    
    /**
     * 修改时间
     */
    private LocalDateTime modifiedAt;
    

}