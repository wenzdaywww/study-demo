package com.www.demo.shiro.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Description shiro配置类
 * @Author www
 * @Date 2021/6/20 16:05
 */
@Configuration
public class ShiroConfig {
    /**
     * @Author www
     * @Date 2021/6/20 17:46
     * @Description 创建用于进行权限信息的验证的Realm类
     * 
     * @return com.www.demo.shiro.config.UserRealm
     */
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }
    /**
     * @Author www
     * @Date 2021/6/20 17:51
     * @Description 创建安全管理器，需要依赖realm类
     * @param userRealm 权限信息
     * @return org.apache.shiro.web.session.mgt.DefaultWebSessionManager
     */
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    /**
     * @Author www
     * @Date 2021/6/20 17:56
     * @Description 创建filter过滤器，设置对应的过滤条件和跳转条件，需要依赖安全管理器
     * @param securityManager 安全管理器
     * @return org.apache.shiro.spring.web.ShiroFilterFactoryBean
     */
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        factoryBean.setSecurityManager(securityManager);
        //添加shiro内置过滤器
        /**
         * anon 无需认证即可访问
         * authc 必须认证才能访问
         * user 必须用于【记住我】功能才能使用
         * perms 用于对某个资源的权限才能访问
         * role 用于某个角色权限才能访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/ws/login","anon");//无需认证即可访问
        filterMap.put("/ws/chat","authc");//必须认证才能访问
        factoryBean.setFilterChainDefinitionMap(filterMap);
        //设置登录页面
        factoryBean.setLoginUrl("/ws/login");
        return factoryBean;
    }
}
