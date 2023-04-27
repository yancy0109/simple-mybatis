package com.yancy.mybatis.binding;

import cn.hutool.core.lang.ClassScanner;
import com.yancy.mybatis.session.Configuration;
import com.yancy.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 映射器注册机
 */
public class MapperRegistry {

    private Configuration configuration;

    public MapperRegistry(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * 将已添加的映射器代理类保存至 HashMap
     */
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if (mapperProxyFactory == null) {
            throw new RuntimeException("Type " + type + " is not known to the MapperRegistry");
        }
        try {
            return mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {
            throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
        }
    }

    /**
     * 注册 Type 类 MapperProxyFactory
     * @param type
     * @param <T>
     */
    public <T> void addMapper(Class<T> type) {
        /**
         * Mapper 必须为接口类型
         */
        if (type.isInterface()) {
            if (hasMapper(type)) {
                // 相同接口添加 throw RuntimeException
                throw new RuntimeException("Type " + type + " is already known to the MapperRegistry.");
            }
            // 注册映射器代理工厂
            knownMappers.put(type, new MapperProxyFactory<>(type));
        }
    }

    /**
     * 对 包路径 进行扫描注册
     * @param packageName   包路径
     */
    public void addMappers(String packageName) {
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        for (Class<?> mapperClass : mapperSet) {
            addMapper(mapperClass);
        }

    }

    /**
     * 判断是否有相同接口注册
     * @param type
     * @return
     * @param <T>
     */
    public <T> boolean hasMapper(Class<T> type) {
        if (knownMappers.get(type) != null) {
            return true;
        }
        return false;
    }
}