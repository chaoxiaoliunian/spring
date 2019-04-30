package com.sjqi.thread.demo;

import java.util.Arrays;

/**
 * @ClassName ThreadGroup
 * @Description 线程组的调用Demo
 * @Author sjqi
 * @Date 8:37 2019/4/30
 * @Version 1.0
 **/
public class ThreadGroup {
    public static void main(String[] args) {
        java.lang.ThreadGroup group = Thread.currentThread().getThreadGroup();
        System.out.println(group);
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10_000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        //在构造线程时如果没有传入线程组，默认为父线程的线程组

        System.out.println(t.getThreadGroup());
        System.out.println(group.activeCount());
        Thread[] ts = new Thread[group.activeCount()];
        group.enumerate(ts);
        Arrays.asList(ts).forEach(System.out::println);

    }
}
