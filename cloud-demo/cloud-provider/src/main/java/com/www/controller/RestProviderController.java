package com.www.controller;

import com.www.data.common.ResponseDTO;
import com.www.data.dto.SysUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>@Description Restful API提供方
 *  * @date 2021/8/1 18:02 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:23 </p>
 */
@RestController
@RequestMapping("/pro")
public class RestProviderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestProviderController.class);
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/get/{name}")
    public ResponseDTO findName(@PathVariable("name") String name){
        LOGGER.info("----> /pro/get/{name}的name={}",name);
        SysUserDTO sysUserDTO = new SysUserDTO();
        sysUserDTO.setUserName(name);
        ResponseDTO<SysUserDTO> responseDTO = new ResponseDTO<SysUserDTO>(sysUserDTO);
        return responseDTO;
    }
    /**
     * <p>@Description 发现服务信息 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/4 22:11 </p>
     * @return java.lang.Object
     */
    @GetMapping("/discovery")
    public Object discovery(){
        List<String> serviceLis = discoveryClient.getServices();
        for (String service:serviceLis) {
            LOGGER.info("-----> services={}",service);
        }
        List<ServiceInstance> instanceList = discoveryClient.getInstances("cloud-provider");
        for (ServiceInstance instance : instanceList) {
            LOGGER.info("-----> instance.ServiceId={},instance.Host={},instance.Port={},instance.Uri={},",
                    instance.getServiceId(),instance.getHost(),instance.getPort(),instance.getUri());
        }
        return discoveryClient;
    }
}
