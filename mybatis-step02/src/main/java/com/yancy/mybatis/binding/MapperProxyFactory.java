package com.yancy.mybatis.binding;

import com.yancy.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * 代理类工厂
 * @author yancy0109
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterfaces;

    public MapperProxyFactory(Class<T> mapperInterfaces) {
        this.mapperInterfaces = mapperInterfaces;
    }

    public T newInstance(SqlSession sqlSession) {
        MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterfaces);
        return (T) Proxy.newProxyInstance(mapperInterfaces.getClassLoader(), new Class[]{mapperInterfaces}, mapperProxy);
    }
}
