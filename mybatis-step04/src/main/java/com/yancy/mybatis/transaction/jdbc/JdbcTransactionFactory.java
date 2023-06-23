package com.yancy.mybatis.transaction.jdbc;

import com.yancy.mybatis.session.TransactionIsolationLevel;
import com.yancy.mybatis.transaction.Transaction;
import com.yancy.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * JdbcTransaction 工厂
 * @author yancy0109
 */
public class JdbcTransactionFactory implements TransactionFactory {

    @Override
    public Transaction newTransaction(Connection connection) {
        return new JdbcTransaction(connection);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }
}
