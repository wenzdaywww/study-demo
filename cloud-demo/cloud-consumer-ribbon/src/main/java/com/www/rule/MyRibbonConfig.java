package com.www.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>@Description 自定义ribbon负载均衡策略
 * 局部负载均衡策略的配置类不推荐放在@ComponentScan扫描路径下，
 * 否则Spring加载后会被覆盖。如果要放到扫描包里面，
 * 可以自定义注解，标志不自动扫描类
 * @ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value =自定义注解.class)})</p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/7 15:17 </p>
 */
@Configuration
public class MyRibbonConfig {
    /**
     * <p>@Description 添加局部负载均衡策略 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/7 15:04 </p>
     * @return com.netflix.loadbalancer.IRule
     */
    @Bean
    public IRule getRule(){
        //返回自定义负载均衡策略算法
        return new MyRibbonRule();
    }
}
