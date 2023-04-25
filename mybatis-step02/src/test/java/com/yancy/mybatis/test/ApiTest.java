package com.yancy.mybatis.test;

import com.yancy.mybatis.binding.MapperRegistry;
import com.yancy.mybatis.session.DefaultSqlSessionFactory;
import com.yancy.mybatis.session.SqlSession;
import com.yancy.mybatis.session.SqlSessionFactory;
import com.yancy.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiTest {
    public static final Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory() {
        // 注册 Mapper
        MapperRegistry mapperRegistry = new MapperRegistry();
        mapperRegistry.addMappers("com.yancy.mybatis.test.dao");

        // 从 SqlSessionFactory 获取 SqlSession
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(mapperRegistry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 测试
        String res = userDao.queryUserAge("10001");
        logger.info("Test Result: {}", res);
    }
}
