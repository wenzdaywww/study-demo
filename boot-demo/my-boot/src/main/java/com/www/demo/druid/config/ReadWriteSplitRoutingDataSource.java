package com.www.demo.druid.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <p>@Description 读写分离数据源动态代理类 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 20:51 </p>
 */
public class ReadWriteSplitRoutingDataSource extends AbstractRoutingDataSource {
    /**
     * <p>@Description 数据源动态代理获取数据源 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 20:51 </p>
     * @return java.lang.Object
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DataBaseContextHolder.getDataBaseType();
    }
}
