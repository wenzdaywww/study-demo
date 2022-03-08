package com.www.zookeeper.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>@Description  </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/3/8 19:55 </p>
 */
public interface ITestService {
    /**
     * <p>@Description 测试 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/3/8 19:56 </p>
     * @param path
     * @return java.lang.String
     */
    String get(String path);
    /**
     * <p>@Description 添加节点数据 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/3/8 20:32 </p>
     * @param path
     * @param msg
     * @return java.lang.String
     */
    String put(String path,String msg);
    /**
     * <p>@Description 更新节点数据 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/3/8 20:32 </p>
     * @param path
     * @param msg
     * @return java.lang.String
     */
    String update(String path,String msg);
}
