package com.www.demo.druid.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * <p>@Description 加载多个数据源配置，如主从数据库 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 20:40 </p>
 */
@Configuration
@EnableTransactionManagement
public class DataSoureConfig {
    private static Logger LOG = LoggerFactory.getLogger(DataSoureConfig.class);
    /** 数据源类型 **/
    @Value("${spring.datasource.druid.type}")
    private Class<? extends DataSource> dataSoureType;

    /**
     * <p>@Description 配置主数据源 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 20:40 </p>
     * @return javax.sql.DataSource
     */
    @Bean("masterDataSource")
    @Primary//优先使用master
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    public DataSource masterDataSource(){
        DataSource masterDataSource = DataSourceBuilder.create().type(dataSoureType).build();
        LOG.info("-----> 创建master数据源");
        return masterDataSource;
    }
    /**
     * <p>@Description 配置从数据源 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 20:41 </p>
     * @return javax.sql.DataSource
     */
    @Bean("slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.slave")
    public DataSource slaveDataSource(){
        DataSource slaveDataSource = DataSourceBuilder.create().type(dataSoureType).build();
        LOG.info("-----> 创建slave数据源");
        return slaveDataSource;
    }
}
