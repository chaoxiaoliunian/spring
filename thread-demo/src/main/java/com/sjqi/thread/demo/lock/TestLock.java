package com.sjqi.thread.demo.lock;

import java.util.stream.Stream;

/**
 * @ClassName TestLock
 * @Description 测试锁
 * @Author sjqi
 * @Date 18:15 2019/4/30
 * @Version 1.0
 **/
public class TestLock {
    public static void main(String[] args) {
        BooleanLock lock = new BooleanLock();
        Stream.of("T1", "T2", "T3", "T4").forEach(name -> new Thread(() -> {
            try {
                lock.lock(1_000L);
                System.out.println(Thread.currentThread().getName()+"aaa");
                Thread.sleep(10_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Lock.TimeOutException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },name).start());
    }
}
