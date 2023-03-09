package com.www.netty.sever.annotation;

import org.springframework.stereotype.Service;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>@Description rpc的服务提供方注解 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/21 14:54 </p>
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface RpcService {
    /**
     * <p>@Description 暴露服务接口类型 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 15:22  </p>
     * @return java.lang.Class<?>
     */
    Class<?> interfaceType() default Object.class;

    /**
     * <p>@Description 服务版本 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 15:22  </p>
     * @return java.lang.String
     */
    String version() default "1.0";
}
