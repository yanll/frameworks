package com.yanll.framework.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 定义Filter级别的公共跨域配置
 */
@Configuration
public class FilterConfiguration extends WebMvcConfigurerAdapter {

    Logger logger = LoggerFactory.getLogger(FilterConfiguration.class);


    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        return null;
    }
}
