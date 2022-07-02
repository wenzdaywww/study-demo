package com.www.demo.redis.controller;

import com.www.demo.model.common.ResponseEnum;
import com.www.demo.model.common.ResponseDTO;
import com.www.demo.model.entity.SysUserEntity;
import com.www.demo.redis.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>@Description redis框架测试控制层 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:06 </p>
 */
@Controller
@RequestMapping("/redis")
public class RedisController {
    private static Logger LOG = LoggerFactory.getLogger(RedisController.class);
    /**
     * <p>@Description 保存数据 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:06 </p>
     * @param type 数据类型
     * @param key key值
     * @param value value值
     * @return com.www.demo.model.common.ResponseDTO<com.www.demo.model.entity.SysUser>
     */
    @RequestMapping("/put/{type}/{key}/{value}")
    public @ResponseBody
    ResponseDTO<SysUserEntity> put(@PathVariable("type") String type, @PathVariable("key") String key, @PathVariable("value") String value){
        SysUserEntity sysUser = new SysUserEntity();
        sysUser.setUserId(key);
        sysUser.setUserName(value);
        LOG.info("-----> put的对象：{}",sysUser);
        if (StringUtils.equals(type,"str")){
            RedisUtil.set(key,sysUser);
        }else if (StringUtils.equals(type,"hash")){
            RedisUtil.hashSet(key,key,sysUser);
        }else if (StringUtils.equals(type,"list")){
            RedisUtil.listSet(key,sysUser);
        }else if (StringUtils.equals(type,"set")){
            RedisUtil.setSet(key,sysUser);
        }else if (StringUtils.equals(type,"zset")){
            RedisUtil.zsetSet(key,sysUser,1);
        }
        return new ResponseDTO<>(ResponseEnum.SUCCESS,sysUser);
    }
    /**
     * <p>@Description 获取数据 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:06 </p>
     * @param type 数据类型
     * @param key key值
     * @return com.www.demo.model.common.ResponseDTO
     */
    @RequestMapping("/get/{type}/{key}")
    public @ResponseBody
    ResponseDTO get(@PathVariable("type") String type, @PathVariable("key") String key){
        Object obj = null;
        if (StringUtils.equals(type,"hash")){
            obj = RedisUtil.hashGet(key);
        }else if (StringUtils.equals(type,"list")){
            obj = RedisUtil.listGet(key);
        }else if (StringUtils.equals(type,"set")){
            obj = RedisUtil.setGet(key);
        }else if (StringUtils.equals(type,"zset")){
            obj = RedisUtil.zsetGet(key);
        }else {
            obj = RedisUtil.get(key);
        }
        LOG.info("-----> put的对象：{}",obj);
        return new ResponseDTO<>(ResponseEnum.SUCCESS,obj);
    }
}
