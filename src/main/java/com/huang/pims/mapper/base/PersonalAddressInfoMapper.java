package com.huang.pims.mapper.base;

import com.huang.pims.beans.base.PersonalAddressInfo;

public interface PersonalAddressInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PersonalAddressInfo record);

    int insertSelective(PersonalAddressInfo record);

    PersonalAddressInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PersonalAddressInfo record);

    int updateByPrimaryKey(PersonalAddressInfo record);
}