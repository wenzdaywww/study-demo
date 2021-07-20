package com.www.demo.druid.config;

/**
 * @author www
 * @version 1.0
 * @description 配置数据源操作
 * 实现一个即时
 * 切换主从数据源的标识并且能保证线程安全的基础下操作数据源（原因是并发会影响数据源
 * 的获取分不清主从，造成在从库进行写操作，影响mysql（mariadb）数据库的机制，导致
 * 服务器异常。这里使用threadocal来解决这个问题）
 * @date 2021/7/20 22:25
 */
public class DataBaseContextHolder {
    /**
     * @description 数据源类型
     * @version 1.0
     * @author www
     * @date 2021/7/20 22:27
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
     * @author www
     * @date 2021/7/20 22:32
     * @description 往线程中设置数据源类型
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
     * @author www
     * @date 2021/7/20 22:34
     * @description 从容器中获取数据源
     * @return com.www.demo.druid.config.DataBaseContextHolder.DataBaseType
     */
    public static DataBaseType getDataBaseType(){
       return contextHolder.get() == null ? DataBaseType.MASTER : contextHolder.get();
    }
    /**
     * @author www
     * @date 2021/7/20 22:35
     * @description 清除容器的数据源类型
     * @return void
     */
    public static void clearDataBaseType(){
        contextHolder.remove();
    }
}
