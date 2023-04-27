package com.yancy.mybatis.session;

import com.yancy.mybatis.binding.MapperRegistry;
import com.yancy.mybatis.mapping.MappedStatement;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置类
 * @author yancy0109
 */
public class Configuration {


    /**
     * 映射注册机
     */
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    /**
     * 映射语句存储容器
     */
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

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
}
