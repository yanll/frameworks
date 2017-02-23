package com.yanll.framework.auth.permission.config;

import com.yanll.framework.auth.permission.filter.permission.ConsolePermissionInteceptor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ConsolePermissionCongfiguration extends WebMvcConfigurerAdapter {
    private final Log logger = LogFactory.getLog(ConsolePermissionCongfiguration.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("******Registry ConsolePermissionInteceptor.*******");
        registry.addInterceptor(consolePermissionInteceptor())/*.addPathPatterns("*//*")*/;
        super.addInterceptors(registry);
    }

    @Bean
    public ConsolePermissionInteceptor consolePermissionInteceptor() {
        return new ConsolePermissionInteceptor();
    }
}
