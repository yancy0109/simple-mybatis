package com.yancy.mybatis.test;

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
import java.io.Reader;

/**
 * @author yancy0109
 */
public class ApiTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_SqlSession() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        String user = userDao.queryUserInfoById("10001");
        LOGGER.info("结果: {}", user);
    }
}
