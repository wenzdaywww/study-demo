package com.www.app.controller;

import com.www.app.feign.CloudProviderService;
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
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * <p>@Description Restful API调用方 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:21 </p>
 */
@RestController
@RequestMapping("/cons")
public class ConsumerRibbonController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerRibbonController.class);
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CloudProviderService cloudProviderService;
    @Autowired
    private DiscoveryClient discoveryClient;
    private String providerURL = "http://cloud-provider";
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
     * <p>@Description 通过eureka调用服务 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/4 22:23 </p>
     * @param name
     * @return com.www.data.common.ResponseDTO<com.www.data.dto.SysUserDTO>
     */
    @GetMapping("/get/{name}")
    public ResponseDTO<SysUserDTO> getName(@PathVariable("name") String name){
        //cloud-provider为服务提供方的spring.application.name
        return restTemplate.getForObject(providerURL+"/pro/get/"+name,ResponseDTO.class);
    }
    /**
     * <p>@Description 通过feign调用服务 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/4 22:23 </p>
     * @param name
     * @return com.www.data.common.ResponseDTO<com.www.data.dto.SysUserDTO>
     */
    @GetMapping("/feign/{name}")
    public ResponseDTO<SysUserDTO> feignName(@PathVariable("name") String name){
        return cloudProviderService.get(name);
    }
    /**
     * <p>@Description 通过feign调用服务 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/4 22:23 </p>
     * @param name
     * @return com.www.data.common.ResponseDTO<com.www.data.dto.SysUserDTO>
     */
    @GetMapping("/hystrix/{name}")
    public ResponseDTO<SysUserDTO> hystrixName(@PathVariable("name") String name){
        return cloudProviderService.find(name);
    }
    /**
     * <p>@Description 获取负载均衡的服务信息 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/4 22:11 </p>
     * @return java.lang.Object
     */
    @GetMapping("/discovery")
    public Object discovery(){
        List<String> serviceLis = discoveryClient.getServices();
        StringBuffer sb = new StringBuffer();
        for (String service:serviceLis) {
            LOGGER.info("-----> services={}",service);
            sb.append("services="+service+"\n");
        }
        List<ServiceInstance> instanceList = discoveryClient.getInstances("cloud-provider");
        for (ServiceInstance instance : instanceList) {
            LOGGER.info("-----> instance.ServiceId={},instance.Host={},instance.Port={},instance.Uri={}",
                    instance.getServiceId(),instance.getHost(),instance.getPort(),instance.getUri());
            sb.append("sinstance.ServiceId="+instance.getServiceId()+",instance.Host="+instance.getHost()+
                    ",instance.Port="+instance.getPort()+",instance.Uri="+instance.getUri()+"\n");
        }
        return sb.toString();
    }
}
