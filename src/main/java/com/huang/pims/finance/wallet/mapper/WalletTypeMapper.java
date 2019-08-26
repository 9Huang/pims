package com.huang.pims.finance.wallet.mapper;

import com.huang.pims.finance.wallet.model.WalletType;
import com.huang.pims.finance.wallet.model.WalletTypeDO;
import com.huang.pims.finance.wallet.vo.WalletTypeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (WalletType)表数据库访问层
 *
 * @author huangj
 * @since 2019-06-22 11:55:17
 */
@Mapper
@Repository
public interface WalletTypeMapper {

    WalletType selectByPrimaryKey(@Param("id") Long id);
    
    List<WalletType> selectAll();
    
    List<WalletType> selectByStatus(@Param("status") String status);

    List<WalletType> selectBy(WalletType walletType);

    List<WalletTypeVO> queryBy(WalletType walletType);

    List<WalletTypeVO> queryAll();

    int insert(WalletType walletType);
    
    int insertSelective(WalletType walletType);

    int updateByPrimaryKey(WalletType walletType);
    
    int updateByPrimaryKeySelective(WalletType walletType);

    int deleteByPrimaryKey(@Param("id") Long id);

}