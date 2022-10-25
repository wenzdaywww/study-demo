package com.www.rpc.consumer.controller;

import com.www.netty.client.annotation.RpcAutowired;
import com.www.rpc.api.IProviderBS;
import com.www.rpc.api.IProviderService;
import com.www.rpc.api.dto.TestInDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>@Description 测试类 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/17 9:12 </p>
 */
@RestController
public class ClientController {
    @RpcAutowired
    private IProviderBS providerBS;
    @RpcAutowired
    private IProviderService providerService;
    /**
     * <p>@Description 测试方法 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/25 11:05  </p>
     * @param name
     * @return java.lang.Object
     */
    @GetMapping("/test/{name}")
    public Object test(@PathVariable("name") String name){
        TestInDTO inDTO = new TestInDTO();
        inDTO.setName(name);
        return providerBS.findTest(inDTO);
    }
    /**
     * <p>@Description 测试方法 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/25 11:05  </p>
     * @param name
     * @return java.lang.Object
     */
    @GetMapping("/test1/{name}")
    public Object test1(@PathVariable("name") String name){
        TestInDTO inDTO = new TestInDTO();
        inDTO.setName(name);
        return providerService.findTest(inDTO);
    }
}
