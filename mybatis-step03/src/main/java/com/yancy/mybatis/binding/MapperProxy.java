package com.yancy.mybatis.binding;

import com.yancy.mybatis.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 映射代理类
 * @author yancy0109
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

    private static final long serialVersionUID = -5795379829819506087L;

    private SqlSession sqlSession;

    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(proxy, args);
        }
        return sqlSession.selectOne(proxy.getClass().getInterfaces()[0].getName() + '.' + method.getName(), args);
    }
}
