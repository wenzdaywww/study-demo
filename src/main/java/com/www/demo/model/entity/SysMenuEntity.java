package com.www.demo.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @version 1.0
 * @Description 菜单表
 * @Author www
 * @Date 2021/6/18 20:53
 */
public class SysMenuEntity implements Serializable {
    /**
     * 菜单id
     **/
    private BigDecimal menuId;
    /**
     * 菜单编码
     **/
    private String menuCode;
    /**
     * 菜单名称
     **/
    private String menuName;
    /**
     * 父级菜单id
     **/
    private BigDecimal parentId;
    /**
     * 菜单路径
     **/
    private String menuUrl;
    /**
     * 菜单图标
     **/
    private String menuIcon;
    /**
     * 菜单顺序
     **/
    private BigDecimal orderNum;
    /**
     * 是否删除
     **/
    private String isDelete;
    /**
     * 更新时间
     **/
    private Date sysUpdateDate;
    /**
     * 创建时间
     **/
    private Date sysCreateDate;

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    private static final long serialVersionUID = 1L;

    public BigDecimal getMenuId() {
        return menuId;
    }

    public void setMenuId(BigDecimal menuId) {
        this.menuId = menuId;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public BigDecimal getParentId() {
        return parentId;
    }

    public void setParentId(BigDecimal parentId) {
        this.parentId = parentId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public BigDecimal getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public Date getSysUpdateDate() {
        return sysUpdateDate;
    }

    public void setSysUpdateDate(Date sysUpdateDate) {
        this.sysUpdateDate = sysUpdateDate;
    }

    public Date getSysCreateDate() {
        return sysCreateDate;
    }

    public void setSysCreateDate(Date sysCreateDate) {
        this.sysCreateDate = sysCreateDate;
    }
}