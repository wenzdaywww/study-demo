package com.www.demo.shiro.config;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.dto.SysUserDTO;
import com.www.demo.model.entity.SysRole;
import com.www.demo.model.entity.SysUser;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>@Description 用于进行权限信息的验证 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:14 </p>
 */
public class UserRealm extends AuthorizingRealm {
    private static Log LOG = LogFactory.getLog(UserRealm.class);
    @Autowired
    private ISysUserService sysUserService;
    /**
     * <p>@Description 授权 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:14 </p>
     * @param principalCollection 授权信息
     * @return org.apache.shiro.authz.AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        LOG.info("-----> shiro授权");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //查询当前用户
        Subject subject = SecurityUtils.getSubject();
        SysUser user = (SysUser)subject.getPrincipal();
        SysUserDTO sysUserDTO = sysUserService.findUserAllInfo(user.getUserId());
        if (CollectionUtils.isNotEmpty(sysUserDTO.getRoleList())){
            List<String> roleList = new ArrayList<>();
            for (SysRole roleEntity : sysUserDTO.getRoleList()){
                roleList.add(roleEntity.getRoleName());
            }
            authorizationInfo.addRoles(roleList);
        }
        return authorizationInfo;
    }
    /**
     * <p>@Description 用户信息认证 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:14 </p>
     * @param authenticationToken 令牌信息
     * @return org.apache.shiro.authc.AuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        LOG.info("-----> shiro认证");
        //获取用户信息
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        //查询用户
        SysUser user = sysUserService.selectByUserId(token.getUsername());
        if (user == null || !StringUtils.equals(user.getUserId(),token.getUsername())){
            return null;
        }
        //密码验证 shiro实现
        return new SimpleAuthenticationInfo(user,user.getPassWord(),"");
    }
}
