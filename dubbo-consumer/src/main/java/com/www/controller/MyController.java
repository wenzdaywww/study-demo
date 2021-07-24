package com.www.controller;

import com.www.consumer.service.IConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author www
 * @version 1.0
 * @description
 * @date 2021/7/13 00:30
 */
@Controller
public class MyController {
    @Autowired
    private IConsumerService consumerService;

    @GetMapping("/find/{id}")
    public @ResponseBody Object findById(@PathVariable("id") String userId){
        return consumerService.findUserById(userId);
    }
}
