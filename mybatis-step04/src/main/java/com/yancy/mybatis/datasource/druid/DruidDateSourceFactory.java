package com.yancy.mybatis.datasource.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.yancy.mybatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Druid 数据源工厂
 * @author yancy0109
 */
public class DruidDateSourceFactory implements DataSourceFactory {

    private Properties props;

    @Override
    public void setProperties(Properties props) {
        this.props = props;
    }

    @Override
    public DataSource getDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(props.getProperty("driver"));
        druidDataSource.setUrl(props.getProperty("url"));
        druidDataSource.setUsername(props.getProperty("username"));
        druidDataSource.setPassword(props.getProperty("password"));
        return druidDataSource;
    }

}
