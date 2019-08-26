package com.huang.pims.finance.wallet.model;


import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;
import javax.persistence.*;

/**
 * (WalletType)实体类
 *
 * @author huangj
 * @since 2019-06-24 22:34:29
 */
@Entity
@Table(name = "finance_wallet_type")
@Data
public class WalletType implements Serializable {
    
    private static final long serialVersionUID = -43683109938090455L;
    
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    /**
     * 钱包类型名
     */
    @Column(name = "wallet_type_name")
    private String walletTypeName;
    
    /**
     * 关联平台id
     */
    @Column(name = "related_platform_id")
    private Long relatedPlatformId;
    
    /**
     * 钱包类别id
     */
    @Column(name = "wallet_class_id")
    private Long walletClassId;

    /**
     * 钱包类别
     */
    private String walletClassName;
    
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