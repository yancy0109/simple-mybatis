package com.yancy.mybatis.transaction;

import com.yancy.mybatis.session.TransactionIsolationLevel;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 事务工厂
 * @author yancy0109
 */
public interface TransactionFactory {

    /**
     * 根据 Connection 创建 Transaction
     * @param connection
     * @return
     */
    Transaction newTransaction(Connection connection);

    /**
     * 根据数据源和事务隔离级别创建 Transaction
     * @param dataSource
     * @param level
     * @param autoCommit
     * @return
     */
    Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit);


}
