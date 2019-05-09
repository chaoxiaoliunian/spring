package com.sjqi.springboot.applicationlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyListener
 * @Description 定义一个业务的listener
 * @Author sjqi
 * @Date 15:27 2019/5/9
 * @Version 1.0
 **/
@Component("myListener")
public class MyListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

        System.out.println("ApplicationListener========"+applicationEvent.getSource()+"==="+applicationEvent.getClass());
        System.out.println("ApplicationListener-======="+((MyEvent)applicationEvent).getText());
    }
}
