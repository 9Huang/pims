package com.huang.pims.finance.wallet.service.impl;

import com.github.pagehelper.PageHelper;
import com.huang.pims.base.enums.DataStatusEnum;
import com.huang.pims.finance.wallet.mapper.WalletTypeMapper;
import com.huang.pims.finance.wallet.model.WalletType;
import com.huang.pims.finance.wallet.service.WalletTypeService;
import com.huang.pims.finance.wallet.vo.WalletTypeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (WalletType)表服务实现类
 *
 * @author huangj
 * @since 2019-06-22 11:55:17
 */
@Service("walletTypeService")
public class WalletTypeServiceImpl implements WalletTypeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WalletTypeServiceImpl.class);

    @Autowired
    private WalletTypeMapper walletTypeMapper;

    @Override
    public WalletType selectById(Long id) {
        return walletTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<WalletType> selectBy(WalletType walletType) {
        return walletTypeMapper.selectBy(walletType);
    }
    
    @Override
    public List<WalletTypeVO> queryAll() {
        return walletTypeMapper.queryAll();
    }
    
    @Override
    public List<WalletTypeVO> queryAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return walletTypeMapper.queryAll();
    }
    
    @Override
    public List<WalletTypeVO> queryByStatus(String status) {
        WalletType walletType = new WalletType();
        walletType.setStatus(status);
        return walletTypeMapper.queryBy(walletType);
    }
    
    @Override
    public List<WalletTypeVO> queryByStatus(String status, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        WalletType walletType = new WalletType();
        walletType.setStatus(status);
        return walletTypeMapper.queryBy(walletType);
    }

    @Override
    public List<WalletTypeVO> queryBy(WalletType walletType) {
        return walletTypeMapper.queryBy(walletType);
    }

    @Override
    public WalletType insert(WalletType walletType) {
        walletTypeMapper.insertSelective(walletType);
        return walletType;
    }

    @Override
    public WalletType update(WalletType walletType) {
        walletTypeMapper.updateByPrimaryKeySelective(walletType);
        return selectById(walletType.getId());
    }

    @Override
    public int deleteById(Long id) {
        return walletTypeMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public int deleteByIdLogically(Long id) {
        WalletType walletType = new WalletType();
        walletType.setId(id);
        walletType.setStatus(DataStatusEnum.INVALID.getCode());
        return walletTypeMapper.updateByPrimaryKeySelective(walletType);
    }
}