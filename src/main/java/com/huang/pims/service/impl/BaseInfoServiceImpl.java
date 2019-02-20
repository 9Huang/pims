package com.huang.pims.service.impl;

import com.huang.pims.beans.base.PersonalBaseInfo;
import com.huang.pims.mapper.base.PersonalBaseInfoMapper;
import com.huang.pims.service.BaseInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"personalBaseInfo"})
public class BaseInfoServiceImpl implements BaseInfoService {

    private static final Logger logger = LoggerFactory.getLogger(BaseInfoServiceImpl.class);

    @Autowired
    private PersonalBaseInfoMapper personalBaseInfoMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Cacheable(key = "'user_'+#id")
    @Override
    public PersonalBaseInfo queryById(Integer id) {
        logger.info("queryById() id=?", id);
        return personalBaseInfoMapper.selectByPrimaryKey(id);
    }




}
