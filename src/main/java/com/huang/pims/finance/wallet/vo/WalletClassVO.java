package com.huang.pims.finance.wallet.vo;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * (WalletClass)实体类
 *
 * @author huangj
 * @since 2019-06-24 22:34:28
 */
@Setter
@Getter
@RequiredArgsConstructor
public class WalletClassVO implements Serializable {
    
    private static final long serialVersionUID = 927816568004904348L;
    
    /**
     * 主键ID
     */
    private Long id;
    
    /**
     * 钱包类别图标
     */
    private String classIcon;
    
    /**
     * 钱包类别名称
     */
    private String className;
    
    /**
     * 钱包类别描述
     */
    private String classDesc;

    public WalletClassVO(Long id, String classIcon, String className, String classDesc) {
        this.id = id;
        this.classIcon = classIcon;
        this.className = className;
        this.classDesc = classDesc;
    }

}