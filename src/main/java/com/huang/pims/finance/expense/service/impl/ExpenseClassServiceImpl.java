package com.huang.pims.finance.expense.service.impl;

import com.github.pagehelper.PageHelper;
import com.huang.pims.base.enums.DataStatusEnum;
import com.huang.pims.finance.expense.model.ExpenseClass;
import com.huang.pims.finance.expense.mapper.ExpenseClassMapper;
import com.huang.pims.finance.expense.service.ExpenseClassService;
import com.huang.pims.finance.expense.vo.ExpenseClassVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * (ExpenseClass)表服务实现类
 *
 * @author huangj
 * @since 2019-06-22 18:54:46
 */
@Service("expenseClassService")
public class ExpenseClassServiceImpl implements ExpenseClassService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExpenseClassServiceImpl.class);

    @Autowired
    private ExpenseClassMapper expenseClassMapper;

    @Override
    public ExpenseClass queryById(Long id) {
        return expenseClassMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public List<ExpenseClassVO> queryAll() {
        return convert(expenseClassMapper.selectAll());
    }
    
    @Override
    public List<ExpenseClassVO> queryAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return convert(expenseClassMapper.selectAll());
    }
    
    @Override
    public List<ExpenseClassVO> queryByStatus(String status) {
        return convert(expenseClassMapper.selectByStatus(status));
    }
    
    @Override
    public List<ExpenseClassVO> queryByStatus(String status, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return convert(expenseClassMapper.selectByStatus(status));
    }
    
    private List<ExpenseClassVO> convert(List<ExpenseClass> expenseClassList) {
        List<ExpenseClassVO> expenseClassVOList = new ArrayList<>();
        if (!Objects.isNull(expenseClassList)) {
            for (ExpenseClass expenseClass : expenseClassList) {
                ExpenseClassVO expenseClassVO = new ExpenseClassVO();
                BeanUtils.copyProperties(expenseClass, expenseClassVO);
                expenseClassVOList.add(expenseClassVO);
            }
        }
        return expenseClassVOList;
    }

    @Override
    public ExpenseClass insert(ExpenseClass expenseClass) {
        expenseClassMapper.insertSelective(expenseClass);
        return expenseClass;
    }

    @Override
    public ExpenseClass update(ExpenseClass expenseClass) {
        expenseClassMapper.updateByPrimaryKeySelective(expenseClass);
        return queryById(expenseClass.getId());
    }

    @Override
    public int deleteById(Long id) {
        return expenseClassMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public int deleteByIdLogically(Long id) {
        ExpenseClass expenseClass = new ExpenseClass();
        expenseClass.setId(id);
        expenseClass.setStatus(DataStatusEnum.INVALID.getCode());
        return expenseClassMapper.updateByPrimaryKeySelective(expenseClass);
    }
}