package com.yanll.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;

public class BeanUtils {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    public static void copyProperties(Object source, Object target) {
        try {
            org.springframework.beans.BeanUtils.copyProperties(source, target);
        } catch (BeansException ex) {
            logger.error("BeanUtils copyProperties BeansException:", ex);
        } catch (Exception ex) {
            logger.error("BeanUtils copyProperties Exception:", ex);
        }
    }


}