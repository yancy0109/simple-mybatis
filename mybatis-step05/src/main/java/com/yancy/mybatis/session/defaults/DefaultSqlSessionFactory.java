package com.yancy.mybatis.session.defaults;

import com.yancy.mybatis.session.Configuration;
import com.yancy.mybatis.session.SqlSession;
import com.yancy.mybatis.session.SqlSessionFactory;

/**
 * SqlSessionFactory 默认实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(this.configuration);
    }
}
