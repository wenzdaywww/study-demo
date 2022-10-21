package com.www.netty.sever.handler;

import com.www.netty.core.dto.NettyRequest;
import com.www.netty.core.dto.NettyResponse;
import com.www.netty.core.protocol.MessageEnum;
import com.www.netty.core.protocol.MessageHeader;
import com.www.netty.core.protocol.MessageProtocol;
import com.www.netty.core.store.LocalServerCache;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>@Description netty响应数据处理器 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/17 17:41 </p>
 */
@Slf4j
public class NettyRequestHandler extends SimpleChannelInboundHandler<MessageProtocol<NettyRequest>> {
    /** 添加线程池 **/
    private final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 10, 60L,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(10000), new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * <p>@Description 客户端连接添加 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/18 11:04  </p>
     * @param ctx
     * @return void
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        log.info("添加客户端{}" , channel.remoteAddress());
    }
    /**
     * <p>@Description 客户端连接激活处理 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/18 11:02  </p>
     * @param ctx
     * @return void
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        log.info("连接客户端{}" , channel.remoteAddress());
    }
    /**
     * <p>@Description 读取客户端发送的消息处理 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/18 11:04  </p>
     * @param ctx
     * @param protocol
     * @return void
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol<NettyRequest> protocol) throws Exception {
        threadPool.submit(() -> {
            log.info("收到客户端的消息：{}" , protocol);
            MessageProtocol<NettyResponse<Object>> responseProt = new MessageProtocol<>();
            MessageHeader header = MessageHeader.build();
            header.setMsgType(MessageEnum.TYPE_RSP.getCode());
            header.setRequestId(protocol.getHeader().getRequestId());
            header.setMsgLen(protocol.getHeader().getMsgLen());
            NettyResponse<Object> response = new NettyResponse<>();
            //通过反射调用方法获取结果
            response.setData(this.handle(protocol.getBody()));
            responseProt.setHeader(header);
            responseProt.setBody(response);
            ctx.writeAndFlush(responseProt);
        });
    }
    /**
     * <p>@Description 通过反射调用方法获取结果 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 15:15  </p>
     * @param request 请求数据
     * @return java.lang.Object
     */
    private Object handle(NettyRequest request){
        String serverName = request.getServiceName() + "-" + request.getVersion();
        Object bean = LocalServerCache.getBean(serverName);
        try {
            if (bean == null){
                throw new RuntimeException("服务：" + serverName + " 不存在。");
            }else {
                Method method = bean.getClass().getMethod(request.getMethod(),request.getParamType());
                return method.invoke(bean,request.getParam());
            }
        } catch (Exception e) {
            log.error("通过反射调用方法获取结果失败，失败原因：{}",e.getMessage());
        }
        return null;
    }
    /**
     * <p>@Description 客户端连接断开处理 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/18 11:04  </p>
     * @param ctx
     * @return void
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        log.info("断开客户端{}" , channel.remoteAddress());
    }
}
