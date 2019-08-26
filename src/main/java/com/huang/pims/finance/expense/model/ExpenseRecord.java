package com.huang.pims.finance.expense.model;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import javax.persistence.*;

/**
 * (ExpenseRecord)实体类
 *
 * @author huangj
 * @since 2019-06-24 22:31:03
 */
@Entity
@Table(name = "finance_expense_record")
@Data
public class ExpenseRecord implements Serializable {
    
    private static final long serialVersionUID = 385989201354245644L;
    
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    /**
     * 支出类型
     */
    @Column(name = "expense_type_id")
    private Integer expenseTypeId;
    
    /**
     * 支出日期
     */
    @Column(name = "expense_date")
    private LocalDate expenseDate;
    
    /**
     * 支出金额
     */
    @Column(name = "expense_amount")
    private BigDecimal expenseAmount;
    
    /**
     * 支出描述
     */
    @Column(name = "expense_desc")
    private String expenseDesc;
    
    /**
     * 付款人
     */
    @Column(name = "payer_id")
    private Long payerId;
    
    /**
     * 付款钱包id
     */
    @Column(name = "wallet_id")
    private Long walletId;
    
    /**
     * 客人id
     */
    @Column(name = "guest_id")
    private Long guestId;
    
    /**
     * 客人名称
     */
    @Column(name = "guest_name")
    private String guestName;
    
    /**
     * 记录状态 1-有效 0-无效
     */
    @Column(name = "status")
    private String status;
    
    /**
     * 创建人
     */
    @Column(name = "created_by")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    /**
     * 修改人
     */
    @Column(name = "modified_by")
    private Long modifiedBy;
    
    /**
     * 修改时间
     */
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;
    

}