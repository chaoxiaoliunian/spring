package com.sjqi.thread.demo.lock;

import java.util.Collection;

/**
 * @ClassName Lock
 * @Description 锁接口
 * @Author sjqi
 * @Date 7:23 2019/5/1
 * @Version 1.0
 **/
public interface Lock {
    class TimeOutException extends Exception {
        public TimeOutException(String message) {
            super(message);
        }
    }

    void lock() throws InterruptedException;

    void lock(long mills) throws TimeOutException,InterruptedException;

    void unlock();

    Collection<Thread> getBlockedThread();

    int getBlockedSize();
}
