package com.huang.pims.finance.expense.service;

import com.huang.pims.finance.expense.model.ExpenseRecord;
import com.huang.pims.finance.expense.vo.ExpenseRecordVO;
import java.util.List;

/**
 * (ExpenseRecord)表服务接口
 *
 * @author huangj
 * @since 2019-06-22 16:48:34
 */
public interface ExpenseRecordService {

    ExpenseRecord queryById(Long id);
    
    List<ExpenseRecordVO> queryAll();
    
    List<ExpenseRecordVO> queryAll(int pageNum, int pageSize);
    
    List<ExpenseRecordVO> queryByStatus(String status);
    
    List<ExpenseRecordVO> queryByStatus(String status, int pageNum, int pageSize);

    ExpenseRecord insert(ExpenseRecord expenseRecord);

    ExpenseRecord update(ExpenseRecord expenseRecord);

    int deleteById(Long id);
    
    int deleteByIdLogically(Long id);

}