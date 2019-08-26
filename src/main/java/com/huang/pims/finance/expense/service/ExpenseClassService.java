package com.huang.pims.finance.expense.service;

import com.huang.pims.finance.expense.model.ExpenseClass;
import com.huang.pims.finance.expense.vo.ExpenseClassVO;
import java.util.List;

/**
 * (ExpenseClass)表服务接口
 *
 * @author huangj
 * @since 2019-06-22 16:48:32
 */
public interface ExpenseClassService {

    ExpenseClass queryById(Long id);
    
    List<ExpenseClassVO> queryAll();
    
    List<ExpenseClassVO> queryAll(int pageNum, int pageSize);
    
    List<ExpenseClassVO> queryByStatus(String status);
    
    List<ExpenseClassVO> queryByStatus(String status, int pageNum, int pageSize);

    ExpenseClass insert(ExpenseClass expenseClass);

    ExpenseClass update(ExpenseClass expenseClass);

    int deleteById(Long id);
    
    int deleteByIdLogically(Long id);

}