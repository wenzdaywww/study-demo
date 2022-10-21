package com.www.netty.core.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <p>@Description JDK序列化 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/21 9:46 </p>
 */
public class JDKSerialization implements INettySerialization {
    /**
     * <p>@Description 序列化 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 9:50  </p>
     * @param obj
     * @return byte[]
     */
    @Override
    public <T> byte[] serialize(T obj) {
        byte[] date = null;
        ByteArrayOutputStream byteOut = null;
        ObjectOutputStream objOut = null;
        try {
            byteOut = new ByteArrayOutputStream();
            objOut = new ObjectOutputStream(byteOut);
            objOut.writeObject(obj);
            date = byteOut.toByteArray();
            byteOut.close();
            objOut.close();
        }catch (Exception e){
        }
        return date;
    }

    /**
     * <p>@Description 反序列化 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 9:50  </p>
     * @param data
     * @return T
     */
    @Override
    public <T> T deserialize(byte[] data) {
        ByteArrayInputStream byteIn;
        ObjectInputStream objIn;
        T obj = null;
        try {
            byteIn = new ByteArrayInputStream(data);
            objIn = new ObjectInputStream(byteIn);
            obj = (T)objIn.readObject();
            byteIn.close();
            objIn.close();
        }catch (Exception e){

        }
        return obj;
    }
}
