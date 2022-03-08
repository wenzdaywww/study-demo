package com.www.zookeeper.service.impl;

import com.www.zookeeper.config.WatcherApi;
import com.www.zookeeper.config.ZkApi;
import com.www.zookeeper.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>@Description  </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/3/8 19:55 </p>
 */
@Service
public class TestServiceImpl implements ITestService {
    @Autowired
    private ZkApi zkApi;

    /**
     * <p>@Description 测试 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/3/8 19:56 </p>
     * @param msg
     * @return java.lang.String
     */
    @Override
    public String get(String path) {
        return zkApi.getData("/"+path,new WatcherApi());
    }

    /**
     * <p>@Description 添加节点数据 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/3/8 20:32 </p>
     *
     * @param path
     * @param msg
     * @return java.lang.String
     */
    @Override
    public String put(String path, String msg) {
        zkApi.createNode("/"+path,msg);
        return msg;
    }

    /**
     * <p>@Description 更新节点数据 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/3/8 20:32 </p>
     *
     * @param path
     * @param msg
     * @return java.lang.String
     */
    @Override
    public String update(String path, String msg) {
        zkApi.updateNode("/"+path,msg);
        return msg;
    }
}
