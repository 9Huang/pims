package com.huang.pims.finance.wallet.service;

import com.huang.pims.finance.wallet.model.WalletType;
import com.huang.pims.finance.wallet.vo.WalletTypeVO;

import java.util.List;

/**
 * (WalletType)表服务接口
 *
 * @author huangj
 * @since 2019-06-22 11:55:17
 */
public interface WalletTypeService {

    WalletType selectById(Long id);

    List<WalletType> selectBy(WalletType walletType);
    
    List<WalletTypeVO> queryAll();
    
    List<WalletTypeVO> queryAll(int pageNum, int pageSize);
    
    List<WalletTypeVO> queryByStatus(String status);
    
    List<WalletTypeVO> queryByStatus(String status, int pageNum, int pageSize);

    List<WalletTypeVO> queryBy(WalletType walletType);

    WalletType insert(WalletType walletType);

    WalletType update(WalletType walletType);

    int deleteById(Long id);
    
    int deleteByIdLogically(Long id);

}