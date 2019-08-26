package com.huang.pims.finance.wallet.vo;


import com.huang.pims.base.enums.DataStatusEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * (WalletType)实体类
 *
 * @author huangj
 * @since 2019-06-24 22:34:30
 */
@Data
public class WalletTypeVO implements Serializable {
    
    private static final long serialVersionUID = 651080727034660691L;
    
    /**
     * 主键ID
     */
    private Long walletTypeId;
    
    /**
     * 钱包类型名
     */
    private String walletTypeName;
    
    /**
     * 钱包类别id
     */
    private Long walletClassId;

    /**
     * 钱包类别名称
     */
    private String walletClassName;
    
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