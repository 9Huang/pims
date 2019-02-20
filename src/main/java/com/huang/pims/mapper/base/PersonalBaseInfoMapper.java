package com.huang.pims.mapper.base;

import com.huang.pims.beans.base.PersonalBaseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PersonalBaseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonalBaseInfo record);

    int insertSelective(PersonalBaseInfo record);

    PersonalBaseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonalBaseInfo record);

    int updateByPrimaryKey(PersonalBaseInfo record);
}