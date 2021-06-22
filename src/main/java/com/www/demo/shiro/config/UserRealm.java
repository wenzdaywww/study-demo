package com.www.demo.shiro.config;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.dto.SysUserDTO;
import com.www.demo.model.entity.SysRoleEntity;
import com.www.demo.model.entity.SysUserEntity;
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
 * @version 1.0
 * @Description 用于进行权限信息的验证
 * @Author www
 * @Date 2021/6/20 16:16
 */
public class UserRealm extends AuthorizingRealm {
    private static Log LOG = LogFactory.getLog(UserRealm.class);
    @Autowired
    private ISysUserService sysUserService;
    /**
     * @Author www
     * @Date 2021/6/20 19:03
     * @Description 授权
     * @param principalCollection
     * @return org.apache.shiro.authz.AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        LOG.info("-----> shiro授权");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //查询当前用户
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity user = (SysUserEntity)subject.getPrincipal();
        SysUserEntity reqUser = new SysUserEntity();
        reqUser.setUserId(user.getUserId());
        SysUserDTO userDTO = sysUserService.findUserInfo(reqUser);
        if (CollectionUtils.isNotEmpty(userDTO.getRoleList())){
            List<String> roleList = new ArrayList<>();
            for (SysRoleEntity roleEntity : userDTO.getRoleList()){
                roleList.add(roleEntity.getRoleName());
            }
            authorizationInfo.addRoles(roleList);
        }
        return authorizationInfo;
    }

    /**
     * @Author www
     * @Date 2021/6/20 19:02
     * @Description 用户信息认证
     * @param authenticationToken 令牌信息
     * @return org.apache.shiro.authc.AuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        LOG.info("-----> shiro认证");
        //获取用户信息
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        //查询用户
        SysUserEntity reqUser = new SysUserEntity();
        reqUser.setUserId(token.getUsername());
        SysUserEntity user = sysUserService.selective(reqUser);
        if (user == null || !StringUtils.equals(user.getUserId(),token.getUsername())){
            return null;
        }
        //密码验证 shiro实现
        return new SimpleAuthenticationInfo(user,user.getPassWord(),"");
    }
}
