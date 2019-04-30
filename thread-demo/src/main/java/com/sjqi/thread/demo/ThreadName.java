package com.sjqi.thread.demo;

/**
 * @ClassName ThreadName
 * @Description 演示 线程名 的生成
 * @Author sjqi
 * @Date 8:28 2019/4/30
 * @Version 1.0
 **/
public class ThreadName {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Thread t=new Thread();
        System.out.println(t.getName());
        Thread t1=new Thread();
        System.out.println(t1.getName());
        //Thread 类持有一个计数器，当不传入线程名称时，线程名称默认为 Thread-计数器++


    }
}
