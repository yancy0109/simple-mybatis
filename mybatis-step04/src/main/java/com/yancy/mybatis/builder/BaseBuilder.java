package com.yancy.mybatis.builder;

import com.yancy.mybatis.session.Configuration;

/**
 * @author yancy0109
 */
public class BaseBuilder {

    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
