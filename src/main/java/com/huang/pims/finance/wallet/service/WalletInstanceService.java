package com.huang.pims.finance.wallet.service;

import com.huang.pims.finance.wallet.model.WalletInstance;
import com.huang.pims.finance.wallet.model.WalletType;
import com.huang.pims.finance.wallet.vo.WalletInstanceVO;
import java.util.List;

/**
 * (WalletInstance)表服务接口
 *
 * @author huangj
 * @since 2019-06-22 16:42:02
 */
public interface WalletInstanceService {

    WalletInstance queryById(Long id);
    
    List<WalletInstanceVO> queryAll();
    
    List<WalletInstanceVO> queryAll(int pageNum, int pageSize);
    
    List<WalletInstanceVO> queryByStatus(String status);
    
    List<WalletInstanceVO> queryByStatus(String status, int pageNum, int pageSize);

    List<WalletInstance> queryBy(WalletInstance walletInstance);

    WalletInstance insert(WalletInstance walletInstance);

    WalletInstance update(WalletInstance walletInstance);

    int deleteById(Long id);
    
    int deleteByIdLogically(Long id);

}