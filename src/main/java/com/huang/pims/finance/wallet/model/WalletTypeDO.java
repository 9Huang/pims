package com.huang.pims.finance.wallet.model;


import com.huang.pims.base.enums.DataStatusEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * (WalletType)实体类
 *
 * @author huangj
 * @since 2019-06-24 22:34:29
 */
@Data
public class WalletTypeDO implements Serializable {
    
    private static final long serialVersionUID = -43683109938090456L;

    /**
     * 钱包类别ID
     */
    private Long walletClassId;

    /**
     * 钱包类别名称
     */
    private String walletClassName;

    /**
     * 钱包类型ID
     */
    private Long walletTypeId;

    /**
     * 钱包类型名称
     */
    private String walletTypeName;
    
    /**
     * 记录状态 1-有效 0-无效
     */
    private String status;

    private DataStatusEnum statusEnum;

    public void setStatus(String status) {
        this.status = status;
        this.statusEnum = DataStatusEnum.getByCode(status);
    }
    

}