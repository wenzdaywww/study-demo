package com.www.controller;

import com.www.data.common.ResponseDTO;
import com.www.data.dto.SysUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>@Description Restful API调用方 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:21 </p>
 */
@RestController
@RequestMapping("/cons")
public class RestConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    /**
     * <p>@Description 直接调用服务 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/4 22:23 </p>
     * @param name
     * @return com.www.data.common.ResponseDTO<com.www.data.dto.SysUserDTO>
     */
    @GetMapping("/find/{name}")
    public ResponseDTO<SysUserDTO> findName(@PathVariable("name") String name){
        return restTemplate.getForObject("http://localhost:8080/pro/get/"+name,ResponseDTO.class);
    }
    /**
     * <p>@Description 直接调用服务 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/4 22:23 </p>
     * @param name
     * @return com.www.data.common.ResponseDTO<com.www.data.dto.SysUserDTO>
     */
    @GetMapping("/get/{name}")
    public ResponseDTO<SysUserDTO> getName(@PathVariable("name") String name){
        //cloud-provider为服务提供方的spring.application.name
        return restTemplate.getForObject("http://cloud-provider/pro/get/"+name,ResponseDTO.class);
    }
}
