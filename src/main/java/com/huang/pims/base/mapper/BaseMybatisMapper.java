package com.huang.pims.base.mapper;

public interface BaseMybatisMapper<R, ID> {

    R selectByPrimaryKey(ID id);

    int insert(R expenseType);

    int insertSelective(R r);

    int updateByPrimaryKey(R r);

    int updateByPrimaryKeySelective(R r);

    int deleteByPrimaryKey(ID id);

}
