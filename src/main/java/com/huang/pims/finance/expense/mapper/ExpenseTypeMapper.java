package com.huang.pims.finance.expense.mapper;

import com.huang.pims.finance.expense.model.ExpenseType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ExpenseType)表数据库访问层
 *
 * @author huangj
 * @since 2019-06-22 19:15:46
 */
@Mapper
@Repository
public interface ExpenseTypeMapper {

    ExpenseType selectByPrimaryKey(@Param("id") Long id);
    
    List<ExpenseType> selectAll();
    
    List<ExpenseType> selectByStatus(@Param("status") String status);
    
    List<ExpenseType> selectBy(ExpenseType expenseType);

    int insert(ExpenseType expenseType);
    
    int insertSelective(ExpenseType expenseType);

    int updateByPrimaryKey(ExpenseType expenseType);
    
    int updateByPrimaryKeySelective(ExpenseType expenseType);

    int deleteByPrimaryKey(@Param("id") Long id);

}