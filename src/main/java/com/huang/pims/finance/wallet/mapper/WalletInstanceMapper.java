package com.huang.pims.finance.wallet.mapper;

import com.huang.pims.finance.wallet.model.WalletInstance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (WalletInstance)表数据库访问层
 *
 * @author huangj
 * @since 2019-06-22 16:42:02
 */
@Mapper
@Repository
public interface WalletInstanceMapper {

    WalletInstance selectByPrimaryKey(@Param("id") Long id);
    
    List<WalletInstance> selectAll();
    
    List<WalletInstance> selectByStatus(@Param("status") String status);

    List<WalletInstance> selectBy(WalletInstance walletInstance);

    int insert(WalletInstance walletInstance);
    
    int insertSelective(WalletInstance walletInstance);

    int updateByPrimaryKey(WalletInstance walletInstance);
    
    int updateByPrimaryKeySelective(WalletInstance walletInstance);

    int deleteByPrimaryKey(@Param("id") Long id);

}