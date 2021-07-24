package com.www.demo.utils;

import com.www.demo.qadmin.controller.login.LoginController;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

/**
 * @author www 对象工具类
 * @version 1.0
 * @description
 * @date 2021/7/18 21:54
 */
public class MyBeanUtils extends BeanUtils {
    private static Logger LOG = LoggerFactory.getLogger(MyBeanUtils.class);
    /**
     * @author www
     * @date 2021/7/18 21:55
     * @description 对象复制
     * @param dest 目标对象
     * @param orig 源对象
     * @return void
     */
    public static void copyProperties(Object dest, Object orig){
        try {
            BeanUtils.copyProperties(dest, orig);
        }catch (Exception e){
            LOG.error(e.getMessage());
        }
    }
}
