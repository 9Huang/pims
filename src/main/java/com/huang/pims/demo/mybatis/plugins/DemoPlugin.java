package com.huang.pims.demo.mybatis.plugins;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Properties;

@Intercepts(value = {
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class DemoPlugin implements Interceptor {


    private static final Logger LOGGER = LoggerFactory.getLogger(DemoPlugin.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        LOGGER.info(Objects.toString(properties));
    }
}
