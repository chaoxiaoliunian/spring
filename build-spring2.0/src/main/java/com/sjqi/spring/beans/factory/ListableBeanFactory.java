package com.sjqi.spring.beans.factory;

import java.util.Map;

/**
 * @ClassName ListableBeanFactory
 * @Description 返回多个javabean
 * @Author sjqi
 * @Date 15:26 2019/4/9
 * @Version 1.0
 **/
public interface ListableBeanFactory extends BeanFactory{
    /**
     * 根据一个类型返回多个该类型的bean
     * @param requiredType
     * @param <T>
     * @return
     */
    <T> Map<String, T> getBeansByType(Class<T> requiredType);
}
