package com.www.demo.mybatis.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>@Description Mybatis配置 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:01 </p>
 */
@Configuration
public class MyBatisConfig {
    /**
     * <p>@Description 新的分页插件,一缓和二缓遵循mybatis的规则,
     *    需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题
     * </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:01 </p>
     * @return com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
