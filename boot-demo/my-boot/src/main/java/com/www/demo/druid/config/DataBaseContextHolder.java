package com.www.demo.druid.config;

/**
 * @author www
 * @version 1.0
 * @description

 * @date 2021/7/20 22:25
 */
/**
 * <p>@Description 配置数据源操作
 * 实现一个即时切换主从数据源的标识并且能保证线程安全的基础下操作数据源（原因是并发会影响数据源
 * 的获取分不清主从，造成在从库进行写操作，影响mysql（mariadb）数据库的机制，导致
 * 服务器异常。这里使用threadocal来解决这个问题）
 * </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 20:38 </p>
 */
public class DataBaseContextHolder {
    /**
     * <p>@Description 数据源类型 </p>
     * <p>@Version 1.0 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 20:39 </p>
     */
    public enum DataBaseType{
        /** 主数据库 **/
        MASTER,
        /** 从数据库 **/
        SLAVE
    }
    /** 数据源线程局部变量 **/
    private static final ThreadLocal<DataBaseType> contextHolder = new ThreadLocal<DataBaseType>();
    /**
     * <p>@Description 往线程中设置数据源类型 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 20:39 </p>
     * @param dataBaseType 数据源类型
     * @return void
     */
    public static void setDataBaseType(DataBaseType dataBaseType){
        if(dataBaseType == null){
            throw  new NullPointerException("----> 数据源类型 is null");
        }
        contextHolder.set(dataBaseType);
    }
    /**
     * <p>@Description 从容器中获取数据源 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 20:40 </p>
     *
     * @return com.www.demo.druid.config.DataBaseContextHolder.DataBaseType
     */
    public static DataBaseType getDataBaseType(){
       return contextHolder.get() == null ? DataBaseType.MASTER : contextHolder.get();
    }
    /**
     * <p>@Description 清除容器的数据源类型 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 20:40 </p>
     *
     * @return void
     */
    public static void clearDataBaseType(){
        contextHolder.remove();
    }
}
