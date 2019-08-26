package com.huang.pims.finance.expense.service;

import com.huang.pims.finance.expense.model.ExpenseType;
import com.huang.pims.finance.expense.vo.ExpenseTypeVO;
import java.util.List;

/**
 * (ExpenseType)表服务接口
 *
 * @author huangj
 * @since 2019-06-22 16:48:34
 */
public interface ExpenseTypeService {

    ExpenseType queryById(Long id);
    
    List<ExpenseTypeVO> queryAll();
    
    List<ExpenseTypeVO> queryAll(int pageNum, int pageSize);
    
    List<ExpenseTypeVO> queryByStatus(String status);
    
    List<ExpenseTypeVO> queryByStatus(String status, int pageNum, int pageSize);

    ExpenseType insert(ExpenseType expenseType);

    ExpenseType update(ExpenseType expenseType);

    int deleteById(Long id);
    
    int deleteByIdLogically(Long id);

}