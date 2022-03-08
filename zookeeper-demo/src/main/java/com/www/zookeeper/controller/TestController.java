package com.www.zookeeper.controller;

import com.www.zookeeper.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>@Description  </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/3/8 19:53 </p>
 */
@RestController
public class TestController {
    @Autowired
    private ITestService testService;
    /**
     * <p>@Description 获取节点数据 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/3/8 20:31 </p>
     * @param msg
     * @return java.lang.String
     */
    @GetMapping("get/{path}")
    public String get(@PathVariable("path") String path){
        return testService.get(path);
    }
    /**
     * <p>@Description 添加节点数据 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/3/8 20:32 </p>
     * @param path
     * @param msg
     * @return java.lang.String
     */
    @GetMapping("put/{path}/{msg}")
    public String put(@PathVariable("path") String path, @PathVariable("msg") String msg){
        return testService.put(path,msg);
    }
    /**
     * <p>@Description 更新节点数据 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/3/8 20:32 </p>
     * @param path
     * @param msg
     * @return java.lang.String
     */
    @GetMapping("up/{path}/{msg}")
    public String update(@PathVariable("path") String path, @PathVariable("msg") String msg){
        return testService.update(path,msg);
    }
}
