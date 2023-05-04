package com.yancy.mybatis.session.defaults;

import com.yancy.mybatis.mapping.Environment;
import com.yancy.mybatis.mapping.MappedStatement;
import com.yancy.mybatis.session.Configuration;
import com.yancy.mybatis.session.SqlSession;

import java.sql.Connection;

public class DefaultSqlSession implements SqlSession {

    /**
     * 配置类
     */
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了! " + "\n方法: " + statement + "\n待执行SQL: " + mappedStatement.getSql());
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        try {

            MappedStatement mappedStatement = configuration.getMappedStatement(statement);
            Environment environment = configuration.getEnvironment();

            Connection connection = environment.getDataSource().getConnection();

            mappedStatement.getBoundSql();
            return (T) ("你被代理了! " + "\n方法: " + statement + "\n入参: " + parameter + "\n待执行SQL: " + mappedStatement.getSql());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }
}

