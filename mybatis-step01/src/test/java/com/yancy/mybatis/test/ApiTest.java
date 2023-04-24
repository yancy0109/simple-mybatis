package com.yancy.mybatis.test;

import com.yancy.mybatis.binding.MapperProxyFactory;
import com.yancy.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yancy0109
 */
public class ApiTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory() {
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);
        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("com.yancy.mybatis.test.dao.IUserDao.queryUserName", "模拟执行Mapper.xml中Sql语句操作: 查询用户姓名");
        sqlSession.put("com.yancy.mybatis.test.dao.IUserDao.queryUserAge", "模拟执行Mapper.xml中Sql语句操作: 查询用户年龄");
        IUserDao userDao = factory.newInstance(sqlSession);

        String res1 = userDao.queryUserName("10001");
        String res2 = userDao.queryUserAge("10001");
        LOGGER.info("测试结果: {}", res1);
        LOGGER.info("测试结果: {}", res2);
    }
}
