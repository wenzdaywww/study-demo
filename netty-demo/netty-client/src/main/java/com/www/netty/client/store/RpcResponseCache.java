package com.www.netty.client.store;

import com.www.netty.core.dto.NettyResponse;
import com.www.netty.core.protocol.MessageProtocol;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>@Description 请求交易返回响应报文缓存 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/21 16:54 </p>
 */
public class RpcResponseCache {
    /** 响应报文缓存对象 **/
    private static Map<String, RpcFuture<MessageProtocol<NettyResponse>>> responseMap = new HashMap<>();
    /**
     * <p>@Description 服务调用前保存请求的响应对象 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 17:05  </p>
     * @param requestId 请求ID
     * @param future 响应报文异步对象
     * @return void
     */
    public static void add(String requestId,RpcFuture<MessageProtocol<NettyResponse>> future){
        responseMap.put(requestId,future);
    }
    /**
     * <p>@Description  </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 17:07  </p>
     * @param requestId 请求ID
     * @param protocol 响应协议对象
     * @return void
     */
    public static void setResponse(String requestId,MessageProtocol<NettyResponse> protocol){
        RpcFuture<MessageProtocol<NettyResponse>> future = responseMap.get(requestId);
        future.setResponse(protocol);
        responseMap.remove(requestId);
    }
}
