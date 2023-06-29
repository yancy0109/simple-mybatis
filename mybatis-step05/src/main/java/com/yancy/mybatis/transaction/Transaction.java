package com.yancy.mybatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 事务接口
 * @author yancy0109
 */
public interface Transaction {

    Connection getConnection() throws SQLException;

    /**
     * 提交
     * @throws SQLException
     */
    void commit() throws SQLException;

    /**
     * 回滚
     * @throws SQLException
     */
    void rollback() throws SQLException;

    /**
     * 关闭
     * @throws SQLException
     */
    void close() throws SQLException;

}
