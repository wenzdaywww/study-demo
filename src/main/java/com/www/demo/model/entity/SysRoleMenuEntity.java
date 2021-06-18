package com.www.demo.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @version 1.0
 * @Description 角色菜单表
 * @Author www
 * @Date 2021/6/18 20:53
 */
public class SysRoleMenuEntity implements Serializable {
    /**
     * 角色菜单id
     **/
    private BigDecimal sysRoleMenuId;
    /**
     * 角色id
     **/
    private BigDecimal roleId;
    /**
     * 菜单id
     **/
    private BigDecimal menuId;
    /**
     * 更新时间
     **/
    private Date sysUpdateDate;
    /**
     * 创建时间
     **/
    private Date sysCreateDate;

    private static final long serialVersionUID = 1L;

    public BigDecimal getSysRoleMenuId() {
        return sysRoleMenuId;
    }

    public void setSysRoleMenuId(BigDecimal sysRoleMenuId) {
        this.sysRoleMenuId = sysRoleMenuId;
    }

    public BigDecimal getRoleId() {
        return roleId;
    }

    public void setRoleId(BigDecimal roleId) {
        this.roleId = roleId;
    }

    public BigDecimal getMenuId() {
        return menuId;
    }

    public void setMenuId(BigDecimal menuId) {
        this.menuId = menuId;
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