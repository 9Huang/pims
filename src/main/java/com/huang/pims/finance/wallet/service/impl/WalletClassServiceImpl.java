package com.huang.pims.finance.wallet.service.impl;

import com.github.pagehelper.PageHelper;
import com.huang.pims.base.enums.DataStatusEnum;
import com.huang.pims.base.vo.SelectOption;
import com.huang.pims.constants.Constants;
import com.huang.pims.finance.wallet.converter.BeanConverterUtils;
import com.huang.pims.finance.wallet.mapper.WalletClassMapper;
import com.huang.pims.finance.wallet.model.WalletClass;
import com.huang.pims.finance.wallet.model.WalletType;
import com.huang.pims.finance.wallet.service.WalletClassService;
import com.huang.pims.finance.wallet.service.WalletTypeService;
import com.huang.pims.finance.wallet.vo.WalletClassVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * (WalletClass)表服务实现类
 *
 * @author huangj
 * @since 2019-06-22 11:22:30
 */
@Service("walletClassService")
public class WalletClassServiceImpl implements WalletClassService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WalletClassServiceImpl.class);

    @Autowired
    private WalletClassMapper walletClassMapper;

    @Autowired
    private WalletTypeService walletTypeService;

    @Override
    @Cacheable(value = "pims", key = "'finance.wallet.class.'+#id")
    public WalletClass queryById(Long id) {
        return walletClassMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public List<WalletClassVO> queryAll() {
        return BeanConverterUtils.toVOList(walletClassMapper.selectAll());
    }
    
    @Override
    public List<WalletClassVO> queryAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return BeanConverterUtils.toVOList(walletClassMapper.selectAll());
    }
    
    @Override
    public List<WalletClassVO> queryByStatus(String status) {
        return BeanConverterUtils.toVOList(walletClassMapper.selectByStatus(status));
    }
    
    @Override
    public List<WalletClassVO> queryByStatus(String status, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return BeanConverterUtils.toVOList(walletClassMapper.selectByStatus(status));
    }

    @Override
    public List<SelectOption> queryByStatusForSelect(String status) {
        List<SelectOption> selectOptionList = null;
        List<WalletClass> walletClassList;
        if (StringUtils.isBlank(status)) {
            walletClassList = walletClassMapper.selectAll();
        } else {
            walletClassList = walletClassMapper.selectByStatus(status);
        }
        if (!Objects.isNull(walletClassList)) {
            selectOptionList = walletClassList.stream().map(walletClass -> {
                SelectOption option = new SelectOption();
                option.setKey("" + walletClass.getId());
                option.setVal(walletClass.getClassName());
                return option;
            }).collect(Collectors.toList());
        }
        return selectOptionList;
    }

    @Override
    @CachePut(value = Constants.APPLICATION_NAME, key = "'finance.wallet.class.'+#walletClass.id")
    public WalletClass insert(WalletClass walletClass) {
        walletClassMapper.insertSelective(walletClass);
        return walletClass;
    }

    @Override
    @CachePut(value = Constants.APPLICATION_NAME, key = "'finance.wallet.class.'+#walletClass.id")
    public WalletClass update(WalletClass walletClass) {
        walletClassMapper.updateByPrimaryKeySelective(walletClass);
        return queryById(walletClass.getId());
    }

    @Override
    @CacheEvict(value = Constants.APPLICATION_NAME, key = "'finance.wallet.class.'+#id")
    public int deleteById(Long id) {
        return walletClassMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    @CacheEvict(value = Constants.APPLICATION_NAME, key = "'finance.wallet.class.'+#id")
    public int deleteByIdLogically(Long id) {
        int count = 0;
        // 检测指定钱包分类下是否存在有效的钱包类型记录
        WalletType walletType = new WalletType();
        walletType.setWalletClassId(id);
        walletType.setStatus(Constants.STATUS_VALID);
        List<WalletType> walletTypeList = walletTypeService.selectBy(walletType);
        if (Objects.isNull(walletType) || walletTypeList.size() == 0) {
            // 如果不存在，则直接删除指定的钱包分类
            WalletClass walletClass = new WalletClass();
            walletClass.setId(id);
            walletClass.setStatus(DataStatusEnum.INVALID.getCode());
            count = walletClassMapper.updateByPrimaryKeySelective(walletClass);
        }
        // 如果存在，则不做删除处理
        return count;
    }
}