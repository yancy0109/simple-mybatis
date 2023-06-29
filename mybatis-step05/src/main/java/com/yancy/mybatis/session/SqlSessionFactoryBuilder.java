package com.yancy.mybatis.session;

import com.yancy.mybatis.builder.xml.XMLConfigBuilder;
import com.yancy.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * SqlSessionFactory 建造者工厂
 * @author yancy0109
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    private SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }

}
