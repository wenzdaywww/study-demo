package com.www.netty.client.proxy;

import com.www.netty.client.core.INettyClient;
import com.www.netty.core.dto.NettyRequest;
import com.www.netty.core.dto.NettyResponse;
import com.www.netty.core.protocol.MessageEnum;
import com.www.netty.core.protocol.MessageHeader;
import com.www.netty.core.protocol.MessageProtocol;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * <p>@Description 客户端RPC代理类实现 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/21 16:08 </p>
 */
public class ClientInvocationHandler implements InvocationHandler {
    private INettyClient nettyClient;
    private Class<?> calzz;
    private String version;
    /**
     * <p>@Description 构造方法 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 16:27  </p>
     * @return
     */
    public ClientInvocationHandler(INettyClient nettyClient,Class<?> calzz,String version){
        this.nettyClient = nettyClient;
        this.calzz = calzz;
        this.version = version;
    }
    /**
     * <p>@Description RPC代理类实现 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 16:09  </p>
     * @param proxy
     * @param method
     * @param args
     * @return java.lang.Object
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MessageProtocol protocol = new MessageProtocol();
        MessageHeader header = MessageHeader.build();
        header.setMsgType(MessageEnum.TYPE_REQ.getCode());
        header.setRequestId(UUID.randomUUID().toString().replaceAll("-",""));
        protocol.setHeader(header);

        NettyRequest request = new NettyRequest();
        request.setServiceName(calzz.getName());
        request.setVersion(version);
        request.setMethod(method.getName());
        request.setParamType(method.getParameterTypes());
        request.setParam(args);
        protocol.setBody(request);
        //通过netty调用
        MessageProtocol<NettyResponse> response = (MessageProtocol<NettyResponse>)nettyClient.sendRequest("127.0.0.1",6668,protocol);
        if (response == null){
            throw new RuntimeException("RPC调用失败。");
        }
        if (response.getHeader().getStatus() != MessageEnum.STATUS_SUC.getCode()){
            throw new RuntimeException("RPC调用结果失败。");
        }
        return response.getBody().getData();
    }
}
