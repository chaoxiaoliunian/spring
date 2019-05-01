package com.sjqi.thread.demo;

import org.omg.SendingContext.RunTime;

/**
 * @ClassName ThreadHook
 * @Description 加入线程退出时的钩子
 * @Author sjqi
 * @Date 8:31 2019/5/1
 * @Version 1.0
 **/
public class ThreadHook {
    public static void main(String[] args) {
        //Runtime.getRuntime().addShutdownHook(new Thread);
        //!!! kill -9 不会触发，慎用。
    }
}
