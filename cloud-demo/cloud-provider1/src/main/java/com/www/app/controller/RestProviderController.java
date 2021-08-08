package com.www.app.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.www.data.common.ResponseDTO;
import com.www.data.dto.SysUserDTO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>@Description Restful API提供方
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:23 </p>
 */
@RestController
@RequestMapping("/pro")
public class RestProviderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestProviderController.class);
    @Value("${server.port}")
    private String port;

    @HystrixCommand(fallbackMethod = "hystrixFindName")//设置备选方案
    @GetMapping("/get/{name}")
    public ResponseDTO findName(@PathVariable("name") String name){
        LOGGER.info("----> /pro/get/{name}的name={}",name);
        if(StringUtils.equals(name,"hystrix")){
            //此处抛出异常，则会执行备选方法hystrixFindName
            throw  new RuntimeException("----> hystrix test");
        }
        SysUserDTO sysUserDTO = new SysUserDTO();
        sysUserDTO.setUserName(name);
        sysUserDTO.setUserId(port);
        ResponseDTO<SysUserDTO> responseDTO = new ResponseDTO<SysUserDTO>(sysUserDTO);
        return responseDTO;
    }
    /**
     * <p>@Description /get/{name}失败的备选方案 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/8 15:33 </p>
     * @param name
     * @return com.www.data.common.ResponseDTO
     */
    public ResponseDTO hystrixFindName(@PathVariable("name") String name){
        LOGGER.info("----> /get/{name}失败的备选方案的name={}",name);
        SysUserDTO sysUserDTO = new SysUserDTO();
        sysUserDTO.setUserName("/get/{name}失败的备选方案的name="+name);
        sysUserDTO.setUserId(port);
        ResponseDTO<SysUserDTO> responseDTO = new ResponseDTO<SysUserDTO>(sysUserDTO);
        return responseDTO;
    }
}
