package com.yanll.framework.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class FilterConfiguration implements WebMvcConfigurer {

    Logger logger = LoggerFactory.getLogger(FilterConfiguration.class);


}
