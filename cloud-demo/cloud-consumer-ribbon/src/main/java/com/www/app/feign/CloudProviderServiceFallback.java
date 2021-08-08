package com.www.app.feign;

import com.www.data.common.ResponseDTO;
import com.www.data.common.ResponseEnum;
import com.www.data.dto.SysUserDTO;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>@Description Feign整合Hystrix实现容错处理（服务降级）</p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/8 11:15 </p>
 */
@Component
public class CloudProviderServiceFallback implements CloudProviderService{
    /**
     * <p>@Description 实现服务降级方法 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/8 16:56 </p>
     * @param name
     * @return com.www.data.common.ResponseDTO
     */
    @Override
    public ResponseDTO get(String name) {
        SysUserDTO sysUserDTO = new SysUserDTO();
        sysUserDTO.setUserName(name);
        return new ResponseDTO(ResponseEnum.FAIL,"实现服务降级:Fallback",sysUserDTO);
    }

    /**
     * <p>@Description 服务方法 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/8 13:47 </p>
     * @param name 名称
     * @return com.www.data.common.ResponseDTO
     */
    @Override
    public ResponseDTO find(String name) {
        SysUserDTO sysUserDTO = new SysUserDTO();
        sysUserDTO.setUserName(name);
        return new ResponseDTO(ResponseEnum.FAIL,"实现服务降级:Fallback",sysUserDTO);
    }
}
