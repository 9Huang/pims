package com.huang.pims.finance.wallet.vo;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * (WalletInstance)实体类
 *
 * @author huangj
 * @since 2019-07-07 22:32:56
 */
@Data
public class WalletInstanceVO implements Serializable {
    
    private static final long serialVersionUID = -55992560406526987L;
    
    /**
     * 主键ID
     */
    private Long id;
    
    /**
     * 钱包APP的所属人id
     */
    private Long walletMasterId;
    
    /**
     * 钱包分类id
     */
    private Long walletClassId;
    
    /**
     * 钱包类型id
     */
    private Long walletTypeId;
    
    /**
     * 钱包标识名称
     */
    private String walletName;
    
    /**
     * 绑定手机号
     */
    private String mobilePhone;
    
    /**
     * 绑定邮箱
     */
    private String email;
    
    /**
     * 钱包余额
     */
    private BigDecimal totalBalance;
    
    /**
     * 可用余额
     */
    private BigDecimal availableBalance;
    
    /**
     * 是否有效 1-有效 0-已注销
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