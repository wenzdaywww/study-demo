package com.www.netty.core.serialize;

import com.www.netty.core.protocol.SerializationEnum;

/**
 * <p>@Description 序列化工厂类 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/21 9:52 </p>
 */
public class SerializationFactory {
    /** JDK序列化 **/
    private static INettySerialization jdkSerialization = new JDKSerialization();
    /** JDK序列化 **/
    private static INettySerialization JsonSerialization = new JsonSerialization();
    /**
     * <p>@Description 获取序列化实例 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 9:58  </p>
     * @param msgEnum 序列化枚举值
     * @return com.www.netty.core.serialize.ISerialization
     */
    public static INettySerialization getInstance(SerializationEnum msgEnum){
        if(msgEnum.getCode() == SerializationEnum.JDK.getCode()){
            return jdkSerialization;
        }else if(msgEnum.getCode() == SerializationEnum.JSON.getCode()){
            return JsonSerialization;
        }
        return null;
    }
}
