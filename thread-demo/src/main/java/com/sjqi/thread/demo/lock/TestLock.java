package com.sjqi.thread.demo.lock;

/**
 * @ClassName TestLock
 * @Description 测试锁
 * @Author sjqi
 * @Date 18:15 2019/4/30
 * @Version 1.0
 **/
public class TestLock {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Lock lock=new Lock();
            try {
                lock.lock();
                System.out.println("aaaa");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();

            }
        });
    }
}
