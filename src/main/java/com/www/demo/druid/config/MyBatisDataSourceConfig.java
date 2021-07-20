package com.www.demo.druid.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.apache.shiro.util.SoftHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * @author www
 * @version 1.0
 * @description mybatis的数据源配置
 * @date 2021/7/20 22:36
 */
@Configuration
//DataSoureConfig这个文件在DataSourceConfiguration加载完成之后再加载MybatisConfiguration
@AutoConfigureAfter(DataSoureConfig.class)
public class MyBatisDataSourceConfig extends MybatisPlusAutoConfiguration {
    private static Logger LOG = LoggerFactory.getLogger(MyBatisDataSourceConfig.class);
    @Resource(name = "masterDataSource")
    private DataSource masterDataSource;
    @Resource(name = "slaveDataSource")
    private DataSource slaveDataSource;

    public MyBatisDataSourceConfig(MybatisPlusProperties properties, ObjectProvider<Interceptor[]> interceptorsProvider, ObjectProvider<TypeHandler[]> typeHandlersProvider, ObjectProvider<LanguageDriver[]> languageDriversProvider, ResourceLoader resourceLoader, ObjectProvider<DatabaseIdProvider> databaseIdProvider, ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider, ObjectProvider<List<MybatisPlusPropertiesCustomizer>> mybatisPlusPropertiesCustomizerProvider, ApplicationContext applicationContext) {
        super(properties, interceptorsProvider, typeHandlersProvider, languageDriversProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider, mybatisPlusPropertiesCustomizerProvider, applicationContext);
    }
    /**
     * @author www
     * @date 2021/7/20 22:53
     * @description 加载数据源类型
     * @return org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
     */
    @Bean(name = "routingDataSource")
    public AbstractRoutingDataSource routingDataSource(){
        ReadWriteSplitRoutingDataSource proxy = new ReadWriteSplitRoutingDataSource();
        SoftHashMap targetDataSource = new SoftHashMap<>();
        targetDataSource.put(DataBaseContextHolder.DataBaseType.MASTER,masterDataSource);
        targetDataSource.put(DataBaseContextHolder.DataBaseType.SLAVE,slaveDataSource);
        //默认数据源
        proxy.setDefaultTargetDataSource(masterDataSource);
        //添加2个主从数据源
        proxy.setTargetDataSources(targetDataSource);
        LOG.info("-----> 加载所有数据源类型");
        return proxy;
    }
    /**
     * @author www
     * @date 2021/7/20 22:39
     * @description 加载数据源到mybatis的SqlSessionFactory中
     * @return org.apache.ibatis.session.SqlSessionFactory
     */
    @Bean(name = "sqlSessionFactory")
    @Override
    public SqlSessionFactory sqlSessionFactory(@Qualifier("routingDataSource") DataSource dataSource) throws Exception {
        LOG.info("-----> 加载mybatis的sqlSessionFactory");
        return super.sqlSessionFactory(dataSource);
    }
}
