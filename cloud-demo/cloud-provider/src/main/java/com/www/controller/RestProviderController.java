package com.www.controller;

import com.www.data.common.ResponseDTO;
import com.www.data.dto.SysUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

    @GetMapping("/get/{name}")
    public ResponseDTO findName(@PathVariable("name") String name){
        LOGGER.info("----> /pro/get/{name}的name={}",name);
        SysUserDTO sysUserDTO = new SysUserDTO();
        sysUserDTO.setUserName(name);
        ResponseDTO<SysUserDTO> responseDTO = new ResponseDTO<SysUserDTO>(sysUserDTO);
        return responseDTO;
    }
}
