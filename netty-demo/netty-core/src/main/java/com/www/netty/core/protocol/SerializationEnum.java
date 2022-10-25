package com.www.netty.core.protocol;

/**
 * <p>@Description 消息序列化枚举值 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/21 11:16 </p>
 */
public enum SerializationEnum {
    /** 序列化算法：JDK算法 **/
    JDK((byte)1),
    /** 序列化算法：JSON算法 **/
    JSON((byte)2);

    /** 枚举值 **/
    private byte code;

    SerializationEnum(byte data){
        this.code = data;
    }
    /**
     * <p>@Description 获取枚举值 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 11:22  </p>
     * @return byte
     */
    public byte getCode(){
        return code;
    }
    /**
     * <p>@Description 根据类型获取对象的序列化算法枚举 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/24 10:00  </p>
     * @param type 类型
     * @return com.www.netty.core.protocol.SerializationEnum
     */
    public static SerializationEnum parseByType(byte type){
        for (SerializationEnum typeEnum : SerializationEnum.values()){
            if (typeEnum.getCode() == type){
                return typeEnum;
            }
        }
        return JDK;
    }
    /**
     * <p>@Description 根据序列化名称获取对应的枚举值 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/24 10:05  </p>
     * @param typeName
     * @return com.www.netty.core.protocol.SerializationEnum
     */
    public static SerializationEnum parseByName(String typeName) {
        for (SerializationEnum typeEnum : SerializationEnum.values()) {
            if (typeEnum.name().equalsIgnoreCase(typeName)) {
                return typeEnum;
            }
        }
        return JDK;
    }
}
