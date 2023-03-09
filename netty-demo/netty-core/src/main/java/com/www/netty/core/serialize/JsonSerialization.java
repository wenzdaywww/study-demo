package com.www.netty.core.serialize;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * <p>@Description Json序列化 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/24 9:45 </p>
 */
public class JsonSerialization implements INettySerialization {

    private static final ObjectMapper MAPPER;

    static {
        MAPPER = generateMapper(JsonInclude.Include.ALWAYS);
    }

    private static ObjectMapper generateMapper(JsonInclude.Include include) {
        ObjectMapper customMapper = new ObjectMapper();
        customMapper.setSerializationInclusion(include);
        customMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        customMapper.configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, true);
        customMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return customMapper;
    }
    /**
     * <p>@Description 序列化 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 9:50  </p>
     * @param obj
     * @return byte[]
     */
    @Override
    public <T> byte[] serialize(T obj){
        try {
            return obj instanceof String ? ((String) obj).getBytes() : MAPPER.writeValueAsString(obj).getBytes(StandardCharsets.UTF_8);
        }catch (Exception e){

        }
        return null;
    }
    /**
     * <p>@Description 反序列化 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 9:50  </p>
     * @param data
     * @param clz
     * @return T
     */
    @Override
    public <T> T deserialize(byte[] data, Class<T> clz){
        try {
            return MAPPER.readValue(Arrays.toString(data), clz);
        }catch (Exception e){

        }
        return null;
    }
}
