package com.yancy.mybatis.session;

import com.yancy.mybatis.binding.MapperRegistry;
import com.yancy.mybatis.datasource.druid.DruidDateSourceFactory;
import com.yancy.mybatis.mapping.Environment;
import com.yancy.mybatis.mapping.MappedStatement;
import com.yancy.mybatis.transaction.jdbc.JdbcTransactionFactory;
import com.yancy.mybatis.type.TypeAliasRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置类
 * @author yancy0109
 */
public class Configuration {

    /**
     * 环境
     */
    protected Environment environment;

    /**
     * 映射注册机
     */
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    /**
     * 映射语句存储容器
     */
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    /**
     * 类型别名注册机
     */
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();

    public Configuration() {
        // 注册 JDBC 事务类
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        // 注册 DRUID 数据源类
        typeAliasRegistry.registerAlias("DRUID", DruidDateSourceFactory.class);
    }

    public void addMapper(Class<?> type) {
        mapperRegistry.addMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

    public TypeAliasRegistry getTypeAliasRegistry() {
        return this.typeAliasRegistry;
    }

    public Environment getEnvironment() {
        return this.environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

}
