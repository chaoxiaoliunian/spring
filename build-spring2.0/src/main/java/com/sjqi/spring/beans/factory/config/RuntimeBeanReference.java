package com.sjqi.spring.beans.factory.config;

/**
 * @ClassName RuntimeBeanReference
 * @Description 引用类型的value
 * @Author sjqi
 * @Date 9:58 2019/4/3
 * @Version 1.0
 **/
public class RuntimeBeanReference {
    private final String beanName;

    public RuntimeBeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
