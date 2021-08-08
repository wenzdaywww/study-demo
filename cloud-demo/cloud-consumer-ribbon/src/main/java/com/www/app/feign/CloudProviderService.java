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
@FeignClient(value = "cloud-provider")//服务提供者名称
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
}
