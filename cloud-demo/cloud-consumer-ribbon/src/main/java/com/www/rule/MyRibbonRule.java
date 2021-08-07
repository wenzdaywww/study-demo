package com.www.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * <p>@Description 自定义负载均衡策略算法 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/7 15:19 </p>
 */
public class MyRibbonRule extends AbstractLoadBalancerRule {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyRibbonRule.class);
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
    /**
     * <p>@Description 自定义负载均衡策略算法实现 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/7 15:25 </p>
     * @param o
     * @return com.netflix.loadbalancer.Server
     */
    @Override
    public Server choose(Object o) {
        ILoadBalancer lb =this.getLoadBalancer();
        if (lb == null) {
            return null;
        } else {
            Server server = null;
            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }
                //活跃的服务
                List<Server> upList = lb.getReachableServers();
                //所有服务
                List<Server> allList = lb.getAllServers();
                if(CollectionUtils.isEmpty(allList) || CollectionUtils.isEmpty(upList)){
                    return null;
                }
                LOGGER.info("-----> 所有服务数量：{}，可用的服务数量：{}",allList.size(),upList.size());
                server = upList.get(0);
                if(server == null){
                    Thread.yield();
                }else {
                    if (server.isAlive()) {
                        LOGGER.info("-----> 自定义负载均衡策略算法实现获取的服务IP：{}，端口：{}",server.getHost(),server.getPort());
                        return server;
                    }
                    server = null;
                    Thread.yield();
                }
            }
            return server;
        }
    }
}
