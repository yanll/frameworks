package com.yanll.framework.auth.permission.config;

import com.yanll.framework.auth.permission.filter.permission.APIPermissionInteceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class APIPermissionCongfiguration implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(APIPermissionCongfiguration.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("******Registry APIPermissionInteceptor.*******");
//        registry.addInterceptor(apiPermissionInteceptor())/*.addPathPatterns("*//*")*/;
//        addInterceptors(registry);
    }

    @Bean
    public APIPermissionInteceptor apiPermissionInteceptor() {
        return new APIPermissionInteceptor();
    }
}
