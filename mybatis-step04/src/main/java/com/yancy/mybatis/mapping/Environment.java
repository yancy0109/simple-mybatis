package com.yancy.mybatis.mapping;

import com.yancy.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;

/**
 * 环境类
 * @author yancy0109
 */
public final class Environment {

    private final String id;

    private final TransactionFactory transactionFactory;

    private final DataSource dataSource;

    public Environment(String id, TransactionFactory transactionFactory, DataSource dataSource) {
        this.id = id;
        this.transactionFactory = transactionFactory;
        this.dataSource = dataSource;
    }

    /**
     * Environment Builder
     */
    public static class Builder {

        private String id;
        private TransactionFactory transactionFactory;
        private DataSource dataSource;

        public Builder(String id) {
            this.id = id;
        }

        public Builder transactionFactory(TransactionFactory transactionFactory) {
            this.transactionFactory = transactionFactory;
            return this;
        }

        public Builder dataSource(DataSource dataSource) {
            this.dataSource = dataSource;
            return this;
        }

        public String id() {
            return this.id;
        }

        public Environment build() {
            return new Environment(this.id, this.transactionFactory, this.dataSource);
        }

    }

    public String getId() {
        return id;
    }

    public TransactionFactory getTransactionFactory() {
        return transactionFactory;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
