package com.www.rpc.api;


import com.www.rpc.api.dto.TestInDTO;
import com.www.rpc.api.dto.TestOutDTO;

/**
 * <p>@Description 测试服务接口类 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/21 14:47 </p>
 */
public interface IProviderService {
    /**
     * <p>@Description 测试方法 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/25 10:33  </p>
     * @param inDTO
     * @return com.www.rpc.provider.dto.TestOutDTO
     */
    TestOutDTO findTest(TestInDTO inDTO);
}
