package com.sjqi.thread.demo.lock;

/**
 * @ClassName Lock
 * @Description 自定义锁对象
 * @Author sjqi 所对象比synchronized更加灵活。
 * @Date 18:11 2019/4/30
 * @Version 1.0
 **/
public class Lock {
    //TODO:增加线程集合用于记录多少线程阻塞在这个锁上了
    //TODO:为了防止其他线程乱释放锁，这里需要记录下做判断。
    //TODO:增加一个超时中断，这也是优于synchronized的地方。
    private volatile boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            this.wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        this.notifyAll();
    }
}
