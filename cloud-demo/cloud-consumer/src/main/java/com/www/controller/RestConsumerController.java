package com.www.controller;

import com.www.data.common.ResponseDTO;
import com.www.data.dto.SysUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author www
 * @version 1.0
 * @description  Restful API调用方
 * @date 2021/8/1 16:20
 */
@RestController
@RequestMapping("/cons")
public class RestConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get/{name}")
    public ResponseDTO<SysUserDTO> findName(@PathVariable("name") String name){
        return restTemplate.getForObject("http://localhost:8080/pro/get/"+name,ResponseDTO.class);
    }
}
