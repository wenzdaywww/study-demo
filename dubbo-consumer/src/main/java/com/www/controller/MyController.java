package com.www.controller;

import com.www.consumer.service.IConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>@Description dubbo消费者controller </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:24 </p>
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
