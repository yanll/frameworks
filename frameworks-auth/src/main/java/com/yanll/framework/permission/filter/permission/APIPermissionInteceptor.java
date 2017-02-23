package com.yanll.framework.web.permission.filter.permission;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by YANLL on 14-2-23.
 * API接口权限控制拦截器（基于Springmvc的URL请求有效）
 * <p>
 */

public class APIPermissionInteceptor extends HandlerInterceptorAdapter {

    private final Log logger = LogFactory.getLog(APIPermissionInteceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("API权限控制...");
        return true;
    }

}
