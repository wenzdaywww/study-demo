package com.www.netty.sever.service;

/**
 * <p>@Description  </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/21 14:47 </p>
 */
public interface IProviderService {

    TestOutDTO findTest(TestInDTO inDTO);
}
