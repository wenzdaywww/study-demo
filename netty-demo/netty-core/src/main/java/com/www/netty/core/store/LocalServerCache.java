package com.www.netty.core.store;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>@Description 本地服务缓存 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/21 15:19 </p>
 */
public class LocalServerCache {
    /** 服务集合 **/
    private static final Map<String,Object> serverMap = new HashMap<>();

    /**
     * <p>@Description 保存服务对象信息 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 15:24  </p>
     * @param serverName 服务名称
     * @param obj 服务对象
     * @return void
     */
    public static void cache(String serverName,Object obj){
        serverMap.put(serverName,obj);
    }
    /**
     * <p>@Description 获取服务对象 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 15:25  </p>
     * @param serverName 服务名称
     * @return java.lang.Object
     */
    public static Object getBean(String serverName){
        return serverMap.get(serverName);
    }
}
