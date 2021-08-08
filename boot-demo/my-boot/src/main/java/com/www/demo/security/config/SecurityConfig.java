package com.www.demo.security.config;

import com.www.demo.security.impl.LoginFailureHandler;
import com.www.demo.security.impl.LoginSuccessHandler;
import com.www.demo.security.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <p>@Description Security配置类 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:10 </p>
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private LoginFailureHandler loginFailureHandler;
    /**
     * <p>@Description 授权,配置如何通过拦截器保护请求 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:10 </p>
     * @param http http请求
     * @return void
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭CSRF（防止网站攻击）
        http.csrf().disable();
        http.authorizeRequests()
                //设置允许访问的路径
                .antMatchers("/","/ws/**","/qadmin","/qadmin/index").permitAll()
                //设置运行角色的路径
                .antMatchers("/qadmin/**").hasRole("admin")
                .and()
                //没有权限默认跳转登录页面
                .formLogin().loginPage("/qadmin")//用户未登录时，访问任何资源都转跳到该路径，即登录页面
                .loginProcessingUrl("/qadmin/login")//登录表单form中action的地址，也就是处理认证请求的路径
                .usernameParameter("user")//登录表单form中用户名输入框input的name名，不修改的话默认是username
                .passwordParameter("pwd")//form中密码输入框input的name名，不修改的话默认是password
                //登录认证成功后默认转跳的路径,如果设置了failureHandler就不能使用该方法
//                .defaultSuccessUrl("/qadmin/main")
                //登录认证成功后的处理器,如果设置了defaultSuccessUrl就不能使用该方法
                .successHandler(loginSuccessHandler)
                //登录认证失败后默认转跳的路径,如果设置了failureHandler就不能使用该方法
//                .failureUrl("/qadmin/index")
                //登录认证失败后的处理器,如果设置了failureUrl就不能使用该方法
                .failureHandler(loginFailureHandler)
                .and()
                ///qadmin/logout非post请求，需要关闭CSRF
                .logout().logoutUrl("/qadmin/logout")//配置注销登录请求url为"/user/logout"，默认为"/logout"
                .logoutSuccessUrl("/qadmin")
                .clearAuthentication(true)//清除身份认证信息，默认为true
                .invalidateHttpSession(true);//是否使session失效，默认为true
        //记住我功能
        http.rememberMe().rememberMeParameter("rmb");//配置记住我的参数
    }
    /**
     * <p>@Description 认证,配置user-detail（用户详细信息）服务 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:11 </p>
     * @param auth 认证信息
     * @return void
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //1、使用xml配置用户信息需要使用该方法
//        super.configure(auth);
        //2、从内存获取用户信息，需要设置密码加密方式
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("admin").password(new BCryptPasswordEncoder().encode("www362412")).roles("admin");
        //3、从数据库查询用户信息
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    /**
     * <p>@Description 配置Spring Security的Filter链 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:11 </p>
     * @param web
     * @return void
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略静态资源的拦截
        web.ignoring().antMatchers("/quickadmin/admin/**","/quickadmin/common/**","/quickadmin/data/**");
    }
}
