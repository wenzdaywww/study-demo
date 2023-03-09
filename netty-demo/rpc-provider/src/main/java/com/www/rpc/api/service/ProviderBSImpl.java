package com.www.rpc.api.service;

import com.www.netty.sever.annotation.RpcService;
import com.www.rpc.api.IProviderBS;
import com.www.rpc.api.dto.TestInDTO;
import com.www.rpc.api.dto.TestOutDTO;

/**
 * <p>@Description 服务提供类 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/21 14:48 </p>
 */
@RpcService(interfaceType = IProviderBS.class,version = "1.0")
public class ProviderBSImpl implements IProviderBS {
    /**
     * <p>@Description 服务提供方法 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/25 11:05  </p>
     * @param inDTO
     * @return com.www.rpc.api.dto.TestOutDTO
     */
    @Override
    public TestOutDTO findTest(TestInDTO inDTO) {
        TestOutDTO outDTO = new TestOutDTO();
        outDTO.setCode("返回="+inDTO.getCode());
        outDTO.setName("返回="+inDTO.getName());
        return outDTO;
    }
}
