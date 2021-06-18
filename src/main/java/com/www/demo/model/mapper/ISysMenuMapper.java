package com.www.demo.model.mapper;

import com.www.demo.model.entity.SysMenuEntity;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @Description 菜单表Mapper
 * @Author www
 * @Date 2021/6/18 20:55
 */
public interface ISysMenuMapper {
    /**
     * @Author www
     * @Date 2021/6/18 21:05
     * @Description 根据菜单ID删除菜单信息
     *
     * @param menuId 菜单ID
     * @return int
     */
    int deleteByPrimaryKey(BigDecimal menuId);
    /**
     * @Author www
     * @Date 2021/6/18 21:06
     * @Description 插入菜单信息
     *
     * @param record 菜单信息
     * @return int
     */
    int insert(SysMenuEntity record);
    /**
     * @Author www
     * @Date 2021/6/18 21:06
     * @Description 插入非空数据的菜单信息
     *
     * @param record 菜单信息
     * @return int
     */
    int insertSelective(SysMenuEntity record);
    /**
     * @Author www
     * @Date 2021/6/18 21:06
     * @Description 根据菜单ID查询菜单信息
     *
     * @param menuId
     * @return com.www.demo.model.entity.SysMenuEntity
     */
    SysMenuEntity selectByPrimaryKey(BigDecimal menuId);
    /**
     * @Author www
     * @Date 2021/6/18 21:06
     * @Description 根据菜单ID更新非空数据
     *
     * @param record 菜单信息
     * @return int
     */
    int updateByPrimaryKeySelective(SysMenuEntity record);
    /**
     * @Author www
     * @Date 2021/6/18 21:06
     * @Description 根据菜单id更新菜单信息
     *
     * @param record 菜单信息
     * @return int
     */
    int updateByPrimaryKey(SysMenuEntity record);
}