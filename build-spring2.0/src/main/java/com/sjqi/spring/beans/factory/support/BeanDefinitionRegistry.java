package com.sjqi.spring.beans.factory.support;

import com.sjqi.spring.beans.factory.config.BeanDefinition;

/**
 * @ClassName BeanDefinitionRegistry
 * @Description 定义bean注册逻辑，用于定义钩子函数。
 * @Author sjqi
 * @Date 11:37 2019/4/2
 * @Version 1.0
 **/
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
    int getBeanDefinitionCount();
}
