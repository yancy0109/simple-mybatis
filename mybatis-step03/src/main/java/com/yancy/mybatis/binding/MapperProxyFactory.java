package com.yancy.mybatis.binding;

import com.yancy.mybatis.session.SqlSession;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 代理类工厂
 * @author yancy0109
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterfaces;

    /**
     * 对 MapperMethod 进行缓存，避免重复解析 SQL语句 和 创建参数对象 (暂未涉及)
     */
    private Map<Method, MapperMethod> methodCache = new ConcurrentHashMap<>();

    public MapperProxyFactory(Class<T> mapperInterfaces) {
        this.mapperInterfaces = mapperInterfaces;
    }

    public T newInstance(SqlSession sqlSession) {
        MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterfaces, methodCache);
        return (T) Proxy.newProxyInstance(mapperInterfaces.getClassLoader(), new Class[]{mapperInterfaces}, mapperProxy);
    }
}
