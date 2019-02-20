package com.huang.pims.mybatis.plugins;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.util.StringUtils;

import java.sql.Connection;
import java.util.Objects;
import java.util.Properties;

@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class MyPagePlugin implements Interceptor {

    private PageParams pageParams;

    private static final String SQL_KEY = "delegate.boundSql.sql";

    private static final String MAPPED_STATEMENT_KEY = "delegate.mappedStatement";

    private static final String PROXY_OBJECT_KEY = "h";


    @Override
    public Object intercept(Invocation invocation) {
        StatementHandler statementHandler = (StatementHandler) getUnProxyObject(invocation.getTarget());

        return null;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        pageParams = new PageParams();
        pageParams.setPageNo(1);
        pageParams.setPageSize(10);
        pageParams.setUseOrNot(false);
        pageParams.setCheckPageNoOrNot(false);
        pageParams.setClearOrderByOrNot(false);
    }

    /**
     * 获取目标类的原始类
     * 过滤掉被多个拦截器拦截而形成的代理
     * @param target
     * @return
     */
    private Object getUnProxyObject(Object target) {
        MetaObject metaStatementHandler = SystemMetaObject.forObject(target);

        Object object = null;
        while (metaStatementHandler.hasGetter(PROXY_OBJECT_KEY)) {
            object = metaStatementHandler.getValue(PROXY_OBJECT_KEY);
            metaStatementHandler = SystemMetaObject.forObject(object);
        }
        if(Objects.isNull(object)) {
            object = target;
        }
        return object;
    }

    /**
     * 检查是否是select语句
     * @param sql
     * @return
     */
    private Boolean checkSql4Select(String sql) {
        return StringUtils.isEmpty(sql) ? Boolean.FALSE : StringUtils.trimWhitespace(sql).startsWith("select");
    }


}
