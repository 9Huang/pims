package com.huang.pims.service;

import com.huang.pims.beans.base.PersonalBaseInfo;

public interface BaseInfoService {

    /**
     * 查询用户的基本信息
     * @param id    用户主键id
     * @return
     */
    PersonalBaseInfo queryById(Integer id);
}
