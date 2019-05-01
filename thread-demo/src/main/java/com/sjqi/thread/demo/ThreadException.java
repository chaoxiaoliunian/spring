package com.sjqi.thread.demo;

/**
 * @ClassName ThreadException
 * @Description 线程异常
 * @Author sjqi
 * @Date 8:26 2019/5/1
 * @Version 1.0
 **/
public class ThreadException {
    private final static int A = 10;
    private final static int B = 0;

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(5_000L);
                int result = A / B;
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
                t.setUncaughtExceptionHandler((thread, e) -> {
            System.out.println(e);
            System.out.println(thread);
        });
        t.start();
    }
}
