package com.huang.pims.finance.wallet.service;

import com.huang.pims.base.vo.SelectOption;
import com.huang.pims.finance.wallet.model.WalletClass;
import com.huang.pims.finance.wallet.vo.WalletClassVO;
import java.util.List;

/**
 * (WalletClass)表服务接口
 *
 * @author huangj
 * @since 2019-06-22 11:22:29
 */
public interface WalletClassService {

    WalletClass queryById(Long id);
    
    List<WalletClassVO> queryAll();
    
    List<WalletClassVO> queryAll(int pageNum, int pageSize);
    
    List<WalletClassVO> queryByStatus(String status);
    
    List<WalletClassVO> queryByStatus(String status, int pageNum, int pageSize);

    List<SelectOption> queryByStatusForSelect(String status);

    WalletClassVO insert(WalletClassVO walletClassVO);

    WalletClass update(WalletClass walletClass);

    int deleteById(Long id);
    
    int deleteByIdLogically(Long id);

}