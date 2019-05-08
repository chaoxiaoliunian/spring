package com.sjqi.thread.demo.observer;

/**
 * @ClassName LifeCycleListener
 * @Description 线程生命周期的监听者
 * @Author sjqi
 * @Date 22:01 2019/5/8
 * @Version 1.0
 **/
public interface LifeCycleListener {
    //
    void onEvent(ObservableRunnable.RunnableEvent event);
}
