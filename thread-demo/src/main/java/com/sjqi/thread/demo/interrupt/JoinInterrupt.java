package com.sjqi.thread.demo.interrupt;

/**
 * @ClassName JoinInterrupt
 * @Description join 的线程中断案例
 * @Author sjqi
 * @Date 9:47 2019/4/30
 * @Version 1.0
 **/
public class JoinInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread main=Thread.currentThread();
        Thread t=new Thread(()->{
            try {
                Thread.sleep(5_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            main.interrupt();
        });
        t.start();
        main.join();
    }
}
