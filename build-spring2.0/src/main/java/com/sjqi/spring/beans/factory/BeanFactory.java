package com.sjqi.spring.beans.factory;

/**
 * @ClassName BeanFactory
 * @Description 顶级Bean工厂
 * @Author sjqi
 * @Date 10:08 2019/4/2
 * @Version 1.0
 **/
public interface BeanFactory {

    Object getBean(String name);

    <T> T getBean(String name, Class<T> requiredTye);

    static void initBeanFactory(String beansConfig) {

    }
}
