package com.yancy.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 数据源工厂
 * @author yancy0109
 */
public interface DataSourceFactory {

    void setProperties(Properties properties);

    DataSource getDataSource();
}
