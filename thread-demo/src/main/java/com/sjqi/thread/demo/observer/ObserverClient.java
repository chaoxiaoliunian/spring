package com.sjqi.thread.demo.observer;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @ClassName ObserverClient
 * @Description 创建线程，调用监听器，打印线程状态。
 * @Author sjqi
 * @Date 22:22 2019/5/8
 * @Version 1.0
 **/
public class ObserverClient {
    public static void main(String[] args) {
        new ThreadLifeCycleListener().concurrentQuery(Arrays.asList("1","2"));
    }
}
