package com.huang.pims.finance.wallet.model;


import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;
import javax.persistence.*;

/**
 * (WalletClass)实体类
 *
 * @author huangj
 * @since 2019-06-24 22:34:27
 */
@Entity
@Table(name = "finance_wallet_class")
@Data
public class WalletClass implements Serializable {
    
    private static final long serialVersionUID = -35758192428525895L;
    
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    /**
     * 钱包类别图标
     */
    @Column(name = "class_icon")
    private String classIcon;
    
    /**
     * 钱包类别名称
     */
    @Column(name = "class_name")
    private String className;
    
    /**
     * 钱包类别描述
     */
    @Column(name = "class_desc")
    private String classDesc;
    
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
    @Column(name = "updated_by")
    private Long updatedBy;
    
    /**
     * 修改时间
     */
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    

}