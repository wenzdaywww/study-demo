package com.www.netty.client.controller;

import com.www.netty.client.core.INettyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>@Description  </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/17 9:12 </p>
 */
@RestController
public class ClientController {
    @Autowired
    private INettyClient nettyClient;

    @GetMapping("/test/{name}")
    public Object test(@PathVariable("name") String name){
        return nettyClient.sendRequest("127.0.0.1",6668,name);
    }
}
