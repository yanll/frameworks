package com.yanll.framework.web.filter;

import com.h2finance.framework.web.filter.CustomCorsRegistration;
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
        logger.info("************FilterRegistrationBean Loading************");
        CustomCorsRegistration coresRegistration = new CustomCorsRegistration("/**");
        coresRegistration.allowedHeaders(CrossOrigin.DEFAULT_ALLOWED_HEADERS).allowedMethods(HttpMethod.GET.name(), HttpMethod.POST.name(), HttpMethod.PUT.name(), HttpMethod.DELETE.name()).allowedOrigins("*");
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", coresRegistration.getCorsConfiguration());
        CorsFilter corsFilter = new CorsFilter(configSource);
        return new FilterRegistrationBean(corsFilter);
    }
}
