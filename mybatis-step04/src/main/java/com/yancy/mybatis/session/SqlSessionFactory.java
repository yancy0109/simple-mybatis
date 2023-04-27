package com.yancy.mybatis.session;

/**
 * SqlSessionFactory
 */
public interface SqlSessionFactory {

    /**
     * 打开一个 Session
     * @return  SqlSession
     */
    SqlSession openSession();
}
