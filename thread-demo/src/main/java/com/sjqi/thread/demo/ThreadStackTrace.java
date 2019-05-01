package com.sjqi.thread.demo;

import java.util.Arrays;
import java.util.Optional;

/**
 * @ClassName ThreadStackTrace
 * @Description 打印线程栈
 * @Author sjqi
 * @Date 8:20 2019/5/1
 * @Version 1.0
 **/
public class ThreadStackTrace {
    public static void main(String[] args) {

        Arrays.asList(Thread.currentThread().getStackTrace()).stream()
                .filter(e -> !e.isNativeMethod())
                .forEach(e -> Optional.of(e.getClassName() + ":" + e.getMethodName() + ":" + e.getLineNumber()).ifPresent(System.out::println));
    }
}
