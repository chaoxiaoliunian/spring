package com.sjqi.thread.demo.ThreadPool;

import java.util.stream.IntStream;

/**
 * @ClassName TestThreadPool
 * @Description 测试线程池
 * @Author sjqi
 * @Date 10:35 2019/5/3
 * @Version 1.0
 **/
public class TestThreadPool {
    public static void main(String[] args) {
        SimpleThreadPool pool = new SimpleThreadPool();
        IntStream.range(0, 10).forEach(n -> {
            pool.submit(() -> {
                try {
                    System.out.println("提交执行任务:"+n);
                    Thread.sleep(5_000L);
                    System.out.println("任务执行完成:"+n);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

    }
}
