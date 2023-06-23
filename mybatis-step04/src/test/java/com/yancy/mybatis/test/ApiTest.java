package com.yancy.mybatis.test;

import com.alibaba.fastjson.JSON;
import com.yancy.mybatis.io.Resources;
import com.yancy.mybatis.session.SqlSession;
import com.yancy.mybatis.session.SqlSessionFactory;
import com.yancy.mybatis.session.SqlSessionFactoryBuilder;
import com.yancy.mybatis.test.dao.IUserDao;
import com.yancy.mybatis.test.po.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author yancy0109
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_SqlSessionFactory() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user = userDao.queryUserInfoById(1L);
        logger.info("测试结果 : {}", JSON.toJSONString(user));
    }

    @Test
    public void test_SqlSession() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User res = sqlSession.selectOne("com.yancy.mybatis.test.dao.IUserDao.queryUserInfoById", new Object[]{1});
        logger.info("测试结果 : {}", JSON.toJSONString(res));
    }
}
