package com.sjqi.thread.demo.lock;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @ClassName Lock
 * @Description 自定义锁对象
 * @Author sjqi 所对象比synchronized更加灵活。
 * @Date 18:11 2019/4/30
 * @Version 1.0
 **/
public class BooleanLock implements Lock {

    private boolean isLocked = false;
    //单纯为了记录有多少线程阻塞在这个锁上了
    private Collection<Thread> blockedQueue = new LinkedList<>();
    //记录锁的拥有者，防止被其他线程修改
    private Thread ownerTHread;

    @Override
    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            this.wait();
            blockedQueue.add(Thread.currentThread());
        }
        blockedQueue.remove(Thread.currentThread());
        ownerTHread=Thread.currentThread();
        isLocked = true;
    }

    @Override
    public synchronized void lock(long mills) throws TimeOutException, InterruptedException {
        if (mills <= 0)
            lock();
        long startTime = System.currentTimeMillis();
        long endTime = startTime + mills;
        while (isLocked) {
            if (System.currentTimeMillis() > endTime) {
                throw new TimeOutException("timeout");
            }
            this.wait();
            blockedQueue.add(Thread.currentThread());
        }
        blockedQueue.remove(Thread.currentThread());
        ownerTHread=Thread.currentThread();
        isLocked = true;
    }

    @Override
    public synchronized void unlock() {
        if (ownerTHread != Thread.currentThread()) {
            return;
        }
        isLocked = false;
        this.notifyAll();
    }

    @Override
    public Collection<Thread> getBlockedThread() {
        return Collections.unmodifiableCollection(this.blockedQueue);
    }

    @Override
    public int getBlockedSize() {
        return blockedQueue.size();
    }
}
