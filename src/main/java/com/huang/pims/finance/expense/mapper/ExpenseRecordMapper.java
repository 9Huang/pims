package com.huang.pims.finance.expense.mapper;

import com.huang.pims.finance.expense.model.ExpenseRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ExpenseRecord)表数据库访问层
 *
 * @author huangj
 * @since 2019-06-22 19:15:46
 */
@Mapper
@Repository
public interface ExpenseRecordMapper {

    ExpenseRecord selectByPrimaryKey(@Param("id") Long id);
    
    List<ExpenseRecord> selectAll();
    
    List<ExpenseRecord> selectByStatus(@Param("status") String status);
    
    List<ExpenseRecord> selectBy(ExpenseRecord expenseRecord);

    int insert(ExpenseRecord expenseRecord);
    
    int insertSelective(ExpenseRecord expenseRecord);

    int updateByPrimaryKey(ExpenseRecord expenseRecord);
    
    int updateByPrimaryKeySelective(ExpenseRecord expenseRecord);

    int deleteByPrimaryKey(@Param("id") Long id);

}