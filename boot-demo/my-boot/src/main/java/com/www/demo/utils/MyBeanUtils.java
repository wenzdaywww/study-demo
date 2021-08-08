package com.www.demo.utils;

import com.www.demo.qadmin.controller.login.LoginController;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

/**
 * <p>@Description 对象工具类 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:15 </p>
 */
public class MyBeanUtils extends BeanUtils {
    private static Logger LOG = LoggerFactory.getLogger(MyBeanUtils.class);
    /**
     * <p>@Description 对象复制 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:16 </p>
     * @param orig 源对象
     * @param dest 目标对象
     * @return void
     */
    public static void copyProperties(Object orig, Object dest){
        try {
            BeanUtils.copyProperties(dest, orig);
        }catch (Exception e){
            LOG.error(e.getMessage());
        }
    }
}
