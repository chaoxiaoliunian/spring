package com.sjqi.springboot;

import com.sjqi.springboot.applicationlistener.MyEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ClassName MyStart
 * @Description 拆解后的Start
 * @Author sjqi
 * @Date 9:24 2019/5/9
 * @Version 1.0
 **/
public class MyStart {
    public static void main(String[] args) {
        ConfigurableApplicationContext context=SpringApplication.run(MyConfiguration.class,args);
       // context.publishEvent(new MyEvent("hello","测试"));
        //context.getEnvironment().getActiveProfiles();
        //System.out.println(context.getBean("myListener"));
    }
}
