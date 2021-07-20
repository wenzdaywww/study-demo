package com.www.demo.druid.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author www
 * @version 1.0
 * @description mybatis读写分离数据源动态代理类
 * @date 2021/7/20 22:41
 */
public class ReadWriteSplitRoutingDataSource extends AbstractRoutingDataSource {
    /**
     * @author www
     * @date 2021/7/20 22:42
     * @description 数据源动态代理获取数据源
     * @return java.lang.Object
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DataBaseContextHolder.getDataBaseType();
    }
}
