package com.www.demo.mvc.config;

import com.www.demo.i18n.I18nLocaleResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>@Description 扩展MVC配置，用于自定义配置MVC </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:00 </p>
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    private static Logger LOG = LoggerFactory.getLogger(MyMvcConfig.class);
    /**
     * <p>@Description 设置视图控制器 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:00 </p>
     * @param registry 视图控制器
     * @return void
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        LOG.info("-----> 加载视图控制器");
        registry.addViewController("/qadmin").setViewName("quickadmin/login");
        registry.addViewController("/qadmin/index").setViewName("quickadmin/login");
        registry.addViewController("/qadmin/main").setViewName("quickadmin/index");
        registry.addViewController("/ws/index").setViewName("websocket/index");
    }
    /**
     * <p>@Description 容器注入i18n国际化解析器 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:01 </p>
     * @return org.springframework.web.servlet.LocaleResolver
     */
    @Bean
    public LocaleResolver localeResolver(){
        return  new I18nLocaleResolver();
    }
    /**
     * <p>@Description 添加拦截器
     * 注：使用spring security时，需要关闭该拦截器
     * </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:01 </p>
     * @param registry
     * @return void
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new QAdminLoginHandlerInterceptor()).addPathPatterns("/qadmin/**")
//                .excludePathPatterns("/qadmin","/qadmin/login","/quickadmin/admin/**","/quickadmin/common/**","/quickadmin/data/**");
//    }
}
