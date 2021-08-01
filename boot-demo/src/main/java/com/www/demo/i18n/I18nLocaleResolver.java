package com.www.demo.i18n;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * <p>@Description i18n国际化文件解析器 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 20:53 </p>
 */
public class I18nLocaleResolver implements LocaleResolver {
    /**
     * <p>@Description 设置语言解析请求 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 20:53 </p>
     * @param httpServletRequest http请求
     * @return java.util.Locale
     */
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String language = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();
        if (StringUtils.isNotBlank(language)){
            String[] str = language.split("_");
            locale = new Locale(str[0],str[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
