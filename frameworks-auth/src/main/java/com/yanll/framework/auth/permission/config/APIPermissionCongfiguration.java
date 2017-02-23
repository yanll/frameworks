package com.yanll.framework.auth.permission.config;

import com.yanll.framework.auth.permission.filter.permission.APIPermissionInteceptor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class APIPermissionCongfiguration extends WebMvcConfigurerAdapter {
    private final Log logger = LogFactory.getLog(APIPermissionCongfiguration.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("******Registry APIPermissionInteceptor.*******");
        registry.addInterceptor(apiPermissionInteceptor())/*.addPathPatterns("*//*")*/;
        super.addInterceptors(registry);
    }

    @Bean
    public APIPermissionInteceptor apiPermissionInteceptor() {
        return new APIPermissionInteceptor();
    }
}
