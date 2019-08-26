package com.huang.pims.finance.expense.model;


import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;
import javax.persistence.*;

/**
 * (ExpenseType)实体类
 *
 * @author huangj
 * @since 2019-06-24 22:31:04
 */
@Entity
@Table(name = "finance_expense_type")
@Data
public class ExpenseType implements Serializable {
    
    private static final long serialVersionUID = 289293520501891110L;
    
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    /**
     * 支出类别
     */
    @Column(name = "expense_class_id")
    private Long expenseClassId;
    
    @Column(name = "expense_type_name")
    private String expenseTypeName;
    
    @Column(name = "expense_type_icon")
    private String expenseTypeIcon;
    
    /**
     * 是否有效  1-有效 0-无效
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