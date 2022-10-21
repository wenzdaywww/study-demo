package com.www.netty.core.serialize;

/**
 * <p>@Description 序列化接口 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/21 9:48 </p>
 */
public interface INettySerialization {
    /**
     * <p>@Description 序列化 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 9:50  </p>
     * @param obj
     * @return byte[]
     */
    <T> byte[] serialize(T obj);
    /**
     * <p>@Description 反序列化 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 9:50  </p>
     * @param data
     * @return T
     */
    <T> T deserialize(byte[] data);
}