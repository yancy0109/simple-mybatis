package com.yancy.mybatis.session;

import java.sql.Connection;

/**
 * 事务隔离级别
 * @author yancy0109
 */
public enum TransactionIsolationLevel {

    // 包括jDBC支持的5个级别
    NONE(Connection.TRANSACTION_NONE),
    READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),
    READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),
    REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),
    SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);

    private final int level;

    TransactionIsolationLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return this.level;
    }
}
