package com.yanll.framework.auth.permission.config;

import com.yanll.framework.auth.permission.filter.permission.ConsolePermissionInteceptor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConsolePermissionCongfiguration implements WebMvcConfigurer {
    private final Log logger = LogFactory.getLog(ConsolePermissionCongfiguration.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("******Registry ConsolePermissionInteceptor.*******");
//        registry.addInterceptor(consolePermissionInteceptor())/*.addPathPatterns("*//*")*/;
//        addInterceptors(registry);
    }


    @Bean
    public ConsolePermissionInteceptor consolePermissionInteceptor() {
        return new ConsolePermissionInteceptor();
    }
}
