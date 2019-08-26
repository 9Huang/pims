package com.huang.pims.finance.expense.service.impl;

import com.github.pagehelper.PageHelper;
import com.huang.pims.base.enums.DataStatusEnum;
import com.huang.pims.finance.expense.model.ExpenseType;
import com.huang.pims.finance.expense.mapper.ExpenseTypeMapper;
import com.huang.pims.finance.expense.service.ExpenseTypeService;
import com.huang.pims.finance.expense.vo.ExpenseTypeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * (ExpenseType)表服务实现类
 *
 * @author huangj
 * @since 2019-06-22 18:54:47
 */
@Service("expenseTypeService")
public class ExpenseTypeServiceImpl implements ExpenseTypeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExpenseTypeServiceImpl.class);

    @Autowired
    private ExpenseTypeMapper expenseTypeMapper;

    @Override
    public ExpenseType queryById(Long id) {
        return expenseTypeMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public List<ExpenseTypeVO> queryAll() {
        return convert(expenseTypeMapper.selectAll());
    }
    
    @Override
    public List<ExpenseTypeVO> queryAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return convert(expenseTypeMapper.selectAll());
    }
    
    @Override
    public List<ExpenseTypeVO> queryByStatus(String status) {
        return convert(expenseTypeMapper.selectByStatus(status));
    }
    
    @Override
    public List<ExpenseTypeVO> queryByStatus(String status, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return convert(expenseTypeMapper.selectByStatus(status));
    }
    
    private List<ExpenseTypeVO> convert(List<ExpenseType> expenseTypeList) {
        List<ExpenseTypeVO> expenseTypeVOList = new ArrayList<>();
        if (!Objects.isNull(expenseTypeList)) {
            for (ExpenseType expenseType : expenseTypeList) {
                ExpenseTypeVO expenseTypeVO = new ExpenseTypeVO();
                BeanUtils.copyProperties(expenseType, expenseTypeVO);
                expenseTypeVOList.add(expenseTypeVO);
            }
        }
        return expenseTypeVOList;
    }

    @Override
    public ExpenseType insert(ExpenseType expenseType) {
        expenseTypeMapper.insertSelective(expenseType);
        return expenseType;
    }

    @Override
    public ExpenseType update(ExpenseType expenseType) {
        expenseTypeMapper.updateByPrimaryKeySelective(expenseType);
        return queryById(expenseType.getId());
    }

    @Override
    public int deleteById(Long id) {
        return expenseTypeMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public int deleteByIdLogically(Long id) {
        ExpenseType expenseType = new ExpenseType();
        expenseType.setId(id);
        expenseType.setStatus(DataStatusEnum.INVALID.getCode());
        return expenseTypeMapper.updateByPrimaryKeySelective(expenseType);
    }
}