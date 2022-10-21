package com.www.netty.sever.service;

import com.www.netty.sever.annotation.RpcService;

/**
 * <p>@Description  </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/21 14:48 </p>
 */
@RpcService(interfaceType = IProviderService.class,version = "1.0")
public class ProviderServiceImpl implements IProviderService{

    @Override
    public TestOutDTO findTest(TestInDTO inDTO) {
        TestOutDTO outDTO = new TestOutDTO();
        outDTO.setCode("返回="+inDTO.getCode());
        outDTO.setName("返回="+inDTO.getName());
        return outDTO;
    }
}
