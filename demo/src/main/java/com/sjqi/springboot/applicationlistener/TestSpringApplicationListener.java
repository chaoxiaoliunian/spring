package com.sjqi.springboot.applicationlistener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @ClassName TestSpringApplicationListener
 * @Description 测试SApplicationListener
 * 包含事件：ContextStartedEvent、ContextRefreshedEvent、ContextStoppedEvent、ContextClosedEvent、RequestHandledEvent
 * @Author sjqi
 * @Date 15:11 2019/5/9
 * @Version 1.0
 **/
@Component
public class TestSpringApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println(contextRefreshedEvent);
        System.out.println("ApplicationListener===容器刷新事件");
    }
}
