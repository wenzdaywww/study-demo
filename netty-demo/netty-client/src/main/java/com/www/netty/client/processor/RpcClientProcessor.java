package com.www.netty.client.processor;

import com.www.netty.client.annotation.RpcAutowired;
import com.www.netty.client.config.NettyClientProperties;
import com.www.netty.client.core.INettyClient;
import com.www.netty.client.proxy.ClientInvocationHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Proxy;

/**
 * <p>@Description bean创建前修改bean的属性 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/21 15:52 </p>
 */
public class RpcClientProcessor implements BeanFactoryPostProcessor, ApplicationContextAware {
    private ApplicationContext applicationContext;
    private INettyClient nettyClient;
    private NettyClientProperties nettyClientProperties;

    public RpcClientProcessor(INettyClient nettyClient,NettyClientProperties nettyClientProperties){
        this.nettyClient = nettyClient;
        this.nettyClientProperties = nettyClientProperties;
    }
    /**
     * <p>@Description bean实例化前处理 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 15:54  </p>
     * @param beanFactory
     * @return void
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
            String beanClassName = beanDefinition.getBeanClassName();
            if (beanClassName != null) {
                Class<?> clazz = ClassUtils.resolveClassName(beanClassName, this.getClass().getClassLoader());
                ReflectionUtils.doWithFields(clazz, field -> {
                    RpcAutowired rpcAutowired = AnnotationUtils.getAnnotation(field, RpcAutowired.class);
                    if (rpcAutowired != null) {
                        Object bean = applicationContext.getBean(clazz);
                        field.setAccessible(true);
                        // 修改为代理对象
                        ReflectionUtils.setField(field, bean, Proxy.newProxyInstance(field.getType().getClassLoader(),new Class[]{field.getType()},
                                new ClientInvocationHandler(nettyClientProperties,nettyClient,field.getType(),rpcAutowired.version())));
                    }
                });
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
