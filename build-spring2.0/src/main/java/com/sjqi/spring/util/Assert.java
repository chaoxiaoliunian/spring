package com.sjqi.spring.util;

/**
 * @ClassName Assert
 * @Description TODO
 * @Author sjqi
 * @Date 10:29 2019/4/2
 * @Version 1.0
 **/
public class Assert {
    /**
     * 判空抛异常
     * @param object
     * @param message
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
