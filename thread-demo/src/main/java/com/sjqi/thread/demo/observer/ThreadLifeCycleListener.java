package com.sjqi.thread.demo.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BinaryLifeCycleListener
 * @Description 线程生命周期的监听者，每当线程生命周期发生变化，将其打印到控制台
 * @Author sjqi
 * @Date 22:13 2019/5/8
 * @Version 1.0
 **/
public class ThreadLifeCycleListener implements LifeCycleListener {
    private final Object LOCK = new Object();
    //在经典的观察者模式中1.ObservableRunnable 应该持有的是观察者列表而不是单个linstener，应该提供一个attach 方法而不是通过
    //构造函数注入的. 2.一个观察者只对应了一个ObservableRunnable,但是这里有多个，而且是多线程，所以需要加入锁。
    //TODO:这种改进的观察者，应用场景是什么？
    public void concurrentQuery(List<String> ids) {
        if (ids == null || ids.size() == 0) {
            return;
        }
        ids.forEach(n -> {
            new Thread(new ObservableRunnable(this) {
                @Override
                public void run() {
                    Thread curThread = Thread.currentThread();
                    try {
                        getLifeCycleListener().onEvent(new RunnableEvent(curThread, ThreadState.RUNNING, null));
                        Thread.sleep(1000L);
                        System.out.println(10/0);
                        getLifeCycleListener().onEvent(new RunnableEvent(curThread, ThreadState.DONE, null));
                    } catch (Exception e) {
                        getLifeCycleListener().onEvent(new RunnableEvent(curThread, ThreadState.ERROR, e));
                    }
                }
            }).start();
        });
    }

    @Override
    public void onEvent(ObservableRunnable.RunnableEvent event) {
        synchronized (LOCK) {
            System.out.println("The runnable [" + event.getThread().getName() + "] data changed and state is [" + event.getThreadState() + "]");
            if (event.getThrowable() != null) {
                System.out.println("The runnable [" + event.getThread().getName() + "] process failed.");
                event.getThrowable().printStackTrace();
            }
        }    }
}
