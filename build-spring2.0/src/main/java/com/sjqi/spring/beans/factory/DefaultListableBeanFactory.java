package com.sjqi.spring.beans.factory;

import com.sjqi.spring.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName DefaultListableBeanFactory
 * @Description 缺省的ListableBeanFactory实现
 * @Author sjqi
 * @Date 15:29 2019/4/9
 * @Version 1.0
 **/
public abstract class DefaultListableBeanFactory implements ListableBeanFactory {
    //BeanDefinition的注册类
    protected final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    //实际单例Bean的容器
    protected final Map<String, Object> beanMap = new ConcurrentHashMap<>();

    public <T> Map<String, T> getBeansByType(Class<T> requiredType) {
        Map<String, T> result = new HashMap<>();
        for (Map.Entry<String, Object> entry : beanMap.entrySet()) {
            Object obj = entry.getValue();
            //TODO:instanceof 判断类型
//            if (obj == requiredType){
//                result.put(entry.getKey(), (T) entry.getValue());
//            }
        }
        return result;
    }

    public Map<String, Object> getAllBeans() {
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            //先進行初始化
             getBean(entry.getKey());
        }
        return beanMap;
    }
}
