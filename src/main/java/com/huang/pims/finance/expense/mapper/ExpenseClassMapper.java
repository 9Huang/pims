package com.huang.pims.finance.expense.mapper;

import com.huang.pims.finance.expense.model.ExpenseClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ExpenseClass)表数据库访问层
 *
 * @author huangj
 * @since 2019-06-22 19:15:45
 */
@Mapper
@Repository
public interface ExpenseClassMapper {

    ExpenseClass selectByPrimaryKey(@Param("id") Long id);
    
    List<ExpenseClass> selectAll();
    
    List<ExpenseClass> selectByStatus(@Param("status") String status);
    
    List<ExpenseClass> selectBy(ExpenseClass expenseClass);

    int insert(ExpenseClass expenseClass);
    
    int insertSelective(ExpenseClass expenseClass);

    int updateByPrimaryKey(ExpenseClass expenseClass);
    
    int updateByPrimaryKeySelective(ExpenseClass expenseClass);

    int deleteByPrimaryKey(@Param("id") Long id);

}