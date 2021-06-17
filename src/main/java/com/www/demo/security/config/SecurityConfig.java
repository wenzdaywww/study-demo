package com.www.demo.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpSession;

/**
 * @version 1.0
 * @Description Security配置类
 * @Author www
 * @Date 2021/6/15 22:11
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * @Author www
     * @Date 2021/6/16 22:07
     * @Description 授权
     * 配置如何通过拦截器保护请求
     * @param http
     * @return void
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭CSRF（防止网站攻击）
        http.csrf().disable();
        http.authorizeRequests()
                //设置允许访问的路径
                .antMatchers("/","/ws","/qadmin","/qadmin/login").permitAll()
                //设置运行角色的路径
                .antMatchers("/qadmin/**").hasRole("admin")
                .and()
                //没有权限默认跳转登录页面
                .formLogin().loginPage("/qadmin")//用户未登录时，访问任何资源都转跳到该路径，即登录页面
                .loginProcessingUrl("/qadmin/login")//登录表单form中action的地址，也就是处理认证请求的路径
                .usernameParameter("user")//登录表单form中用户名输入框input的name名，不修改的话默认是username
                .passwordParameter("pwd")//form中密码输入框input的name名，不修改的话默认是password
                .defaultSuccessUrl("/qadmin/main")//登录认证成功后默认转跳的路径
                .failureForwardUrl("/qadmin")//登录认证失败后默认转跳的路径
                .and()
                ///qadmin/logout非post请求，需要关闭CSRF
                .logout().logoutUrl("/qadmin/logout")//配置注销登录请求url为"/user/logout"，默认为"/logout"
                .logoutSuccessUrl("/qadmin")
                .clearAuthentication(true)//清除身份认证信息，默认为true
                .invalidateHttpSession(true);//是否使session失效，默认为true
    }
    /**
     * @Author www
     * @Date 2021/6/16 22:10
     * @Description 认证
     * 配置user-detail（用户详细信息）服务
     * @param auth
     * @return void
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //从内存获取登录信息
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("www362412")).roles("admin");
    }
    /**
     * @Author www
     * @Date 2021/6/16 22:50
     * @Description 配置Spring Security的Filter链。
     *
     * @param web
     * @return void
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}
