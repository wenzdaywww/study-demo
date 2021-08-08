package com.www.app.feign;

import com.www.data.common.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>@Description cloud-provider服务提供者feign客户端 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/8 11:15 </p>
 */
@Component
//fallback:只设置回退内容
//fallbackFactory:可设置回退内容，且可设置查看服务失败的异常信息
//如果两个都设置，优先执行fallback
@FeignClient(value = "cloud-provider",fallback = CloudProviderServiceFallback.class,fallbackFactory = CloudProviderServiceFallbackFactory.class)//服务提供者名称
public interface CloudProviderService {
    /**
     * <p>@Description 服务方法 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/8 13:47 </p>
     * @param name 名称
     * @return com.www.data.common.ResponseDTO
     */
    @GetMapping("/pro/get/{name}")
    ResponseDTO get(@PathVariable("name") String name);
    /**
     * <p>@Description 服务方法 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/8 13:47 </p>
     * @param name 名称
     * @return com.www.data.common.ResponseDTO
     */
    @GetMapping("/pro/find/{name}")
    ResponseDTO find(@PathVariable("name") String name);
}
