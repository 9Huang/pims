package com.huang.pims.finance.expense.service.impl;

import com.github.pagehelper.PageHelper;
import com.huang.pims.base.enums.DataStatusEnum;
import com.huang.pims.finance.expense.model.ExpenseRecord;
import com.huang.pims.finance.expense.mapper.ExpenseRecordMapper;
import com.huang.pims.finance.expense.service.ExpenseRecordService;
import com.huang.pims.finance.expense.vo.ExpenseRecordVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * (ExpenseRecord)表服务实现类
 *
 * @author huangj
 * @since 2019-06-22 18:54:47
 */
@Service("expenseRecordService")
public class ExpenseRecordServiceImpl implements ExpenseRecordService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExpenseRecordServiceImpl.class);

    @Autowired
    private ExpenseRecordMapper expenseRecordMapper;

    @Override
    public ExpenseRecord queryById(Long id) {
        return expenseRecordMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public List<ExpenseRecordVO> queryAll() {
        return convert(expenseRecordMapper.selectAll());
    }
    
    @Override
    public List<ExpenseRecordVO> queryAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return convert(expenseRecordMapper.selectAll());
    }
    
    @Override
    public List<ExpenseRecordVO> queryByStatus(String status) {
        return convert(expenseRecordMapper.selectByStatus(status));
    }
    
    @Override
    public List<ExpenseRecordVO> queryByStatus(String status, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return convert(expenseRecordMapper.selectByStatus(status));
    }
    
    private List<ExpenseRecordVO> convert(List<ExpenseRecord> expenseRecordList) {
        List<ExpenseRecordVO> expenseRecordVOList = new ArrayList<>();
        if (!Objects.isNull(expenseRecordList)) {
            for (ExpenseRecord expenseRecord : expenseRecordList) {
                ExpenseRecordVO expenseRecordVO = new ExpenseRecordVO();
                BeanUtils.copyProperties(expenseRecord, expenseRecordVO);
                expenseRecordVOList.add(expenseRecordVO);
            }
        }
        return expenseRecordVOList;
    }

    @Override
    public ExpenseRecord insert(ExpenseRecord expenseRecord) {
        expenseRecordMapper.insertSelective(expenseRecord);
        return expenseRecord;
    }

    @Override
    public ExpenseRecord update(ExpenseRecord expenseRecord) {
        expenseRecordMapper.updateByPrimaryKeySelective(expenseRecord);
        return queryById(expenseRecord.getId());
    }

    @Override
    public int deleteById(Long id) {
        return expenseRecordMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public int deleteByIdLogically(Long id) {
        ExpenseRecord expenseRecord = new ExpenseRecord();
        expenseRecord.setId(id);
        expenseRecord.setStatus(DataStatusEnum.INVALID.getCode());
        return expenseRecordMapper.updateByPrimaryKeySelective(expenseRecord);
    }
}