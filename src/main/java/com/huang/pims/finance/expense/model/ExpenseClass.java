package com.huang.pims.finance.expense.model;


import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;
import javax.persistence.*;

/**
 * (ExpenseClass)实体类
 *
 * @author huangj
 * @since 2019-06-24 22:31:02
 */
@Entity
@Table(name = "finance_expense_class")
@Data
public class ExpenseClass implements Serializable {
    
    private static final long serialVersionUID = 270755759277576872L;
    
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
    @Column(name = "expense_class_name")
    private String expenseClassName;
    
    /**
     * 支出类型描述
     */
    @Column(name = "expense_class_desc")
    private String expenseClassDesc;
    
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