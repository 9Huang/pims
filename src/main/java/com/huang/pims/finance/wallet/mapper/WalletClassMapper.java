package com.huang.pims.finance.wallet.mapper;

import com.huang.pims.finance.wallet.model.WalletClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (WalletClass)表数据库访问层
 *
 * @author huangj
 * @since 2019-06-22 11:22:28
 */
@Mapper
@Repository
public interface WalletClassMapper {

    WalletClass selectByPrimaryKey(@Param("id") Long id);
    
    List<WalletClass> selectAll();
    
    List<WalletClass> selectByStatus(@Param("status") String status);

    int insert(WalletClass walletClass);
    
    int insertSelective(WalletClass walletClass);

    int updateByPrimaryKey(WalletClass walletClass);
    
    int updateByPrimaryKeySelective(WalletClass walletClass);

    int deleteByPrimaryKey(@Param("id") Long id);

}