package com.sjqi.thread.demo.join;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @ClassName ThreadJoin
 * @Description 展示线程Join 的使用
 * @Author sjqi
 * @Date 9:18 2019/4/30
 * @Version 1.0
 **/
public class ThreadJoin {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            IntStream.range(0, 1000).forEach(i -> System.out.println(Thread.currentThread().getName() + ">>"+i));
        });
        Thread t1 = new Thread(() -> {
            IntStream.range(0, 1000).forEach(i -> System.out.println(Thread.currentThread().getName() + ">>"+i));
        });
        t.start();
        t1.start();
        try {
            t.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Optional.of("子线程执行完成").ifPresent(System.out::println);
        IntStream.range(0, 1000).forEach(i -> System.out.println(Thread.currentThread().getName() + ">>"+i));

    }
}
