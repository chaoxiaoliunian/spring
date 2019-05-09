package com.sjqi.springboot.applicationlistener;

import org.springframework.context.ApplicationEvent;

/**
 * @ClassName MyEvent
 * @Description TODO
 * @Author sjqi
 * @Date 15:28 2019/5/9
 * @Version 1.0
 **/
public class MyEvent extends ApplicationEvent {
    String text;
    public MyEvent(Object source,String text) {
        super(source);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
