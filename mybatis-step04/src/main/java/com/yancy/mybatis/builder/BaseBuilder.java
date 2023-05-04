package com.yancy.mybatis.builder;

import com.yancy.mybatis.session.Configuration;
import com.yancy.mybatis.type.TypeAliasRegistry;

/**
 * @author yancy0109
 */
public class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
