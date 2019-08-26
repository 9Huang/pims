package com.huang.pims.finance.wallet.model;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import javax.persistence.*;

/**
 * (WalletInstance)实体类
 *
 * @author huangj
 * @since 2019-07-07 22:32:55
 */
@Entity
@Table(name = "finance_wallet_instance")
@Data
public class WalletInstance implements Serializable {
    
    private static final long serialVersionUID = 810076163431314985L;
    
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    /**
     * 钱包APP的所属人id
     */
    @Column(name = "wallet_master_id")
    private Long walletMasterId;
    
    /**
     * 钱包分类id
     */
    @Column(name = "wallet_class_id")
    private Long walletClassId;
    
    /**
     * 钱包类型id
     */
    @Column(name = "wallet_type_id")
    private Long walletTypeId;
    
    /**
     * 钱包标识名称
     */
    @Column(name = "wallet_name")
    private String walletName;
    
    /**
     * 绑定手机号
     */
    @Column(name = "mobile_phone")
    private String mobilePhone;
    
    /**
     * 绑定邮箱
     */
    @Column(name = "email")
    private String email;
    
    /**
     * 钱包余额
     */
    @Column(name = "total_balance")
    private BigDecimal totalBalance;
    
    /**
     * 可用余额
     */
    @Column(name = "available_balance")
    private BigDecimal availableBalance;
    
    /**
     * 是否有效 1-有效 0-已注销
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