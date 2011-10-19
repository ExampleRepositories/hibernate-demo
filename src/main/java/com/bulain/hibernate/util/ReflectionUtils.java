package com.bulain.hibernate.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ReflectionUtils {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtils.class);

    public static <T> Class<T> getSuperClassGenricType(final Class clazz) {
        return getSuperClassGenricType(clazz, 0);
    }

    public static Class getSuperClassGenricType(final Class clazz, final int index) {

        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            logger.warn("{}'s superclass not ParameterizedType", clazz.getSimpleName());
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            logger.warn("Index: {}, Size of {}'s Parameterized Type: {}" + index, clazz.getSimpleName(), params.length);
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            logger.warn("{} not set the actual class on superclass generic parameter", clazz.getSimpleName());
            return Object.class;
        }

        return (Class) params[index];
    }
}
