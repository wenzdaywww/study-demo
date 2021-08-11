package com.www.zuul.config;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.www.data.common.ResponseDTO;
import com.www.data.common.ResponseEnum;

import java.util.Arrays;
import java.util.List;

/**
 * <p>@Description 自定义zuul过滤器 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/11 22:40 </p>
 */
public class IpFilter extends ZuulFilter {
    // IP黑名单列表
    private List<String> blackIpList = Arrays.asList("127.0.0.1");
    /**
     * <p>@Description 过滤器类型，可选值有 pre、route、post、error。 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/11 22:42 </p>
     * @return java.lang.String
     */
    @Override
    public String filterType() {
        return "pre";
    }
    /**
     * <p>@Description 过滤器的执行顺序，数值越小，优先级越高。 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/11 22:44 </p>
     * @return int
     */
    @Override
    public int filterOrder() {
        return 0;
    }
    /**
     * <p>@Description 是否执行该过滤器，true 为执行，false 为不执行，这个也可以利用配置中心来实现，达到动态的开启和关闭过滤器。 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/11 22:43 </p>
     * @return boolean
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }
    /**
     * <p>@Description 执行自己的业务逻辑，本段代码中是通过判断请求的 IP 是否在黑名单中，
     * 决定是否进行拦截。blackIpList 字段是 IP 的黑名单，判断条件成立之后，
     * 通过设置 ctx.setSendZuulResponse（false），
     * 告诉 Zuul 不需要将当前请求转发到后端的服务了。通过 setResponseBody 返回数据给客户端。 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/11 22:44 </p>
     *
     * @return java.lang.Object
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        String ip = "127.0.0.1";
        // 在黑名单中禁用
        if (blackIpList.contains(ip)) {
            //告诉 Zuul 不需要将当前请求转发到后端的服务。原理体现在 shouldFilter() 方法上
            ctx.setSendZuulResponse(false);
            ResponseDTO data = new ResponseDTO(ResponseEnum.FAIL,"非法请求",null);
            ctx.setResponseBody(JSON.toJSONString(data));
            ctx.getResponse().setContentType("application/json; charset=utf-8");
            return null;
        }
        return null;
    }
}
