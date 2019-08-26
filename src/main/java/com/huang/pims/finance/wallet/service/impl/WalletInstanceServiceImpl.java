package com.huang.pims.finance.wallet.service.impl;

import com.github.pagehelper.PageHelper;
import com.huang.pims.base.enums.DataStatusEnum;
import com.huang.pims.finance.wallet.mapper.WalletInstanceMapper;
import com.huang.pims.finance.wallet.model.WalletInstance;
import com.huang.pims.finance.wallet.service.WalletInstanceService;
import com.huang.pims.finance.wallet.vo.WalletInstanceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * (WalletInstance)表服务实现类
 *
 * @author huangj
 * @since 2019-06-22 16:42:02
 */
@Service("walletInstanceService")
public class WalletInstanceServiceImpl implements WalletInstanceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WalletInstanceServiceImpl.class);

    @Autowired
    private WalletInstanceMapper walletInstanceMapper;

    @Override
    public WalletInstance queryById(Long id) {
        return walletInstanceMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public List<WalletInstanceVO> queryAll() {
        return convert(walletInstanceMapper.selectAll());
    }
    
    @Override
    public List<WalletInstanceVO> queryAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return convert(walletInstanceMapper.selectAll());
    }
    
    @Override
    public List<WalletInstanceVO> queryByStatus(String status) {
        return convert(walletInstanceMapper.selectByStatus(status));
    }
    
    @Override
    public List<WalletInstanceVO> queryByStatus(String status, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return convert(walletInstanceMapper.selectByStatus(status));
    }

    @Override
    public List<WalletInstance> queryBy(WalletInstance walletInstance) {
        return walletInstanceMapper.selectBy(walletInstance);
    }

    private List<WalletInstanceVO> convert(List<WalletInstance> walletInstanceList) {
        List<WalletInstanceVO> walletInstanceVOList = new ArrayList<>();
        if (!Objects.isNull(walletInstanceList)) {
            for (WalletInstance walletInstance : walletInstanceList) {
                WalletInstanceVO walletInstanceVO = new WalletInstanceVO();
                BeanUtils.copyProperties(walletInstance, walletInstanceVO);
                walletInstanceVOList.add(walletInstanceVO);
            }
        }
        return walletInstanceVOList;
    }

    @Override
    public WalletInstance insert(WalletInstance walletInstance) {
        walletInstanceMapper.insertSelective(walletInstance);
        return walletInstance;
    }

    @Override
    public WalletInstance update(WalletInstance walletInstance) {
        walletInstanceMapper.updateByPrimaryKeySelective(walletInstance);
        return queryById(walletInstance.getId());
    }

    @Override
    public int deleteById(Long id) {
        return walletInstanceMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public int deleteByIdLogically(Long id) {
        WalletInstance walletInstance = new WalletInstance();
        walletInstance.setId(id);
        walletInstance.setStatus(DataStatusEnum.INVALID.getCode());
        return walletInstanceMapper.updateByPrimaryKeySelective(walletInstance);
    }
}