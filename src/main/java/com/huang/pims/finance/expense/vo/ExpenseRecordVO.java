package com.huang.pims.finance.expense.vo;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * (ExpenseRecord)实体类
 *
 * @author huangj
 * @since 2019-06-24 22:34:09
 */
@Data
public class ExpenseRecordVO implements Serializable {
    
    private static final long serialVersionUID = -41552211098339883L;
    
    /**
     * 主键ID
     */
    private Long id;
    
    /**
     * 支出类型
     */
    private Integer expenseTypeId;
    
    /**
     * 支出日期
     */
    private LocalDate expenseDate;
    
    /**
     * 支出金额
     */
    private BigDecimal expenseAmount;
    
    /**
     * 支出描述
     */
    private String expenseDesc;
    
    /**
     * 付款人
     */
    private Long payerId;
    
    /**
     * 付款钱包id
     */
    private Long walletId;
    
    /**
     * 客人id
     */
    private Long guestId;
    
    /**
     * 客人名称
     */
    private String guestName;
    
    /**
     * 记录状态 1-有效 0-无效
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