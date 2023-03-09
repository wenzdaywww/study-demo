package com.www.netty.client.store;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * <p>@Description rpc结果异步返回 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/21 16:56 </p>
 */
public class RpcFuture<T> implements Future<T> {
    /** 响应结果 **/
    private T response;
    /**
     * 因为请求和响应是一一对应的，所以这里是1
     * 使用 CountDownLatch 等待线程
     */
    private CountDownLatch countDownLatch = new CountDownLatch(1);
    /**
     * <p>@Description 取消 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/25 11:00  </p>
     * @param mayInterruptIfRunning
     * @return boolean
     */
    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }
    /**
     * <p>@Description 是否取消 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/25 11:00  </p>
     * @return boolean
     */
    @Override
    public boolean isCancelled() {
        return false;
    }
    /**
     * <p>@Description 响应数据不为空 表示完成 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 17:03  </p>
     * @return boolean
     */
    @Override
    public boolean isDone() {
        return this.response != null;
    }
    /**
     * <p>@Description  获取结果</p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 17:02  </p>
     * @return T
     */
    @Override
    public T get() throws InterruptedException, ExecutionException {
        countDownLatch.await();
        return response;
    }
    /**
     * <p>@Description 获取结果，含超时时间 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 17:02  </p>
     * @param timeout 超时时间
     * @param unit 时间单位
     * @return T
     */
    @Override
    public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        if (countDownLatch.await(timeout,unit)){
            return response;
        }
        return null;
    }
    /**
     * <p>@Description 设置响应报文 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 17:01  </p>
     * @param response
     * @return void
     */
    public void setResponse(T response) {
        this.response = response;
        countDownLatch.countDown();
    }
}
