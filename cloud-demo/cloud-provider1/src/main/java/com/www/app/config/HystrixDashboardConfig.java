package com.www.app.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>@Description Hystrix Dashboard监控配置 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/9 22:50 </p>
 */
@Configuration
public class HystrixDashboardConfig {
    /**
     * <p>@Description 注册Hystrix Dashboard需要的servlet </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/9 22:53 </p>
     * @return org.springframework.boot.web.servlet.ServletRegistrationBean
     */
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        ///actuator/hystrix.stream为Hystrix Dashboard指定路径
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;
    }
}
