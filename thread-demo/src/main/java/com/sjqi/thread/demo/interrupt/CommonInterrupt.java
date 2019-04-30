package com.sjqi.thread.demo.interrupt;

/**
 * @ClassName CommonInterrupt
 * @Description 大部分情况的Interrupt
 * @Author sjqi
 * @Date 11:11 2019/4/30
 * @Version 1.0
 **/
public class CommonInterrupt {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.interrupted()) {
                    System.out.println("线程被中断"+Thread.currentThread().getName());
                    break;
                }
                System.out.println(">>>"+Thread.interrupted());
            }
        });
        t1.start();
        try {
            Thread.sleep(5_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }

}
