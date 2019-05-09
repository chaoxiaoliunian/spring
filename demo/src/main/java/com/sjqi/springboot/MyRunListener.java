package com.sjqi.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @ClassName MyRunListener
 * @Description 自定义的run listener
 * @Author sjqi
 * @Date 15:00 2019/5/9
 * @Version 1.0
 **/
public class MyRunListener implements SpringApplicationRunListener {
    SpringApplication sa;
    String[] args;

    public MyRunListener(SpringApplication sa, String[] args) {
        this.sa = sa;
        this.args = args;
    }

    @Override
    public void starting() {
        System.out.println("======= starting");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("======= environmentPrepared");

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("========contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("========contextLoaded");

    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("========started");

    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("========running");

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("========contextPrepared");

    }
}
