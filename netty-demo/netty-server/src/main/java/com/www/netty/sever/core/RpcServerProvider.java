package com.www.netty.sever.core;

import com.www.netty.core.store.LocalServerCache;
import com.www.netty.sever.annotation.RpcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * <p>@Description RPC服务提供方bean实例化后处理 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/21 15:01 </p>
 */
@Slf4j
public class RpcServerProvider implements BeanPostProcessor {
    /**
     * <p>@Description bean实例化后会调用到 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 15:02  </p>
     * @param bean
     * @param beanName
     * @return java.lang.Object
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        RpcService rpcService = bean.getClass().getAnnotation(RpcService.class);
        if (rpcService != null){
            String serverName = rpcService.interfaceType().getName();
            String version = rpcService.version();
            LocalServerCache.cache(serverName + "-" + version,bean);
        }
        return bean;
    }
}
