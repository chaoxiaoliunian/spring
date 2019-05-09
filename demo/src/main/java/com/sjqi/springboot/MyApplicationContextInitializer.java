package com.sjqi.springboot;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ClassName MyApplicationContextInitializer
 * @Description 自定义初始化，在 context 的refresh之前触发，需要配置在spring.factories中
 * @Author sjqi
 * @Date 15:50 2019/5/9
 * @Version 1.0
 **/
public class MyApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("在 refresh前触发");
    }
}
