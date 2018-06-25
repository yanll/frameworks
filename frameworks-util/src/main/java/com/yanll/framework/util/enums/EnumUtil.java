package com.yanll.framework.util.enums;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YANLL on 2016/11/11.
 */
public class EnumUtil {
    private static final Logger logger = LoggerFactory.getLogger(EnumUtil.class);

    private static final String DEAULT_KEY_FIELD = "getKey";
    private static final String DEAULT_VALUE_FIELD = "getValue";

    public static <T> boolean exists(T key, Class em) throws RuntimeException {
        try {
            Method m = em.getMethod(DEAULT_KEY_FIELD);
            Object[] objs = em.getEnumConstants();
            for (Object obj : objs) {
                if (m.invoke(obj).equals(key)) return true;
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("NoSuchMethodException", e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException("InvocationTargetException", e);
        } catch (Exception e) {
            throw new RuntimeException("Exception", e);
        }
        return false;
    }

    public static Map<String, String> toMap(Class em) {
        Map<String, String> map = new HashMap<>();
        try {
            Method m = em.getMethod(DEAULT_KEY_FIELD);
            Method m_ = em.getMethod(DEAULT_VALUE_FIELD);
            Object[] objs = em.getEnumConstants();
            for (Object obj : objs) {
                String k = (String) m.invoke(obj);
                String v = (String) m_.invoke(obj);
                map.put(k, v);
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("NoSuchMethodException", e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException("InvocationTargetException", e);
        } catch (Exception e) {
            throw new RuntimeException("Exception", e);
        }
        return map;
    }
}
