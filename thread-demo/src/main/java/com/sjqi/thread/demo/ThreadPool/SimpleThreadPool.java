package com.sjqi.thread.demo.ThreadPool;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName SimpleThreadPool
 * @Description 自定义线程池，考虑点：
 * 1.任务队列;
 * 2.拒绝策略(抛出异常，直接丢弃，阻塞，临时队列)；
 * 3.线程池初始大小(init min)；
 * 4.活跃线程数(active)；
 * 5.最大个数(max)；
 * 初始不满足，尝试active，如果不满足则max，如果max不满足，加入任务队列，如果任务队列不满足，执行拒绝策略
 * 线程池销毁方法
 * @Author sjqi
 * @Date 9:42 2019/5/1
 * @Version 1.0
 **/
//TODO:定义拒绝策略，定义线程池的销毁。
public class SimpleThreadPool {
    private final static List<Thread> THREAD_POOL = new LinkedList<>();
    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();
    private int init;
    private int active;
    private int max;
    private static final int DEFAULT_INIT_SIZE = 2;
    private static final int DEFAULT_ACTIVE_SIZE = 4;
    private static final int DEFAULT_MAX_SIZE = 8;

    public SimpleThreadPool() {
        this(DEFAULT_INIT_SIZE, DEFAULT_ACTIVE_SIZE, DEFAULT_MAX_SIZE);
    }

    public SimpleThreadPool(int init, int active, int max) {
        this.init = init;
        this.active = active;
        this.max = max;
        init(this.init);
    }

    public void init(int size) {
        //线程池初始化:创建并开启指定个数的线程。
        for (int i = 0; i < size; i++) {
            THREAD_POOL.add(new Worker(null, "thread-" + i));
        }
        for (Thread t : THREAD_POOL) {
            t.start();
        }
    }

    public enum ThreadState {
        RUNNABLE, RUNNING, BLOCKED, DEAD;
    }

    public void submit(Runnable runnable) {
        synchronized (TASK_QUEUE) {
            TASK_QUEUE.add(runnable);
            TASK_QUEUE.notify();
        }

    }

    public static class Worker extends Thread {
        //新创建出来的线程处于就绪状态
        private ThreadState threadState = ThreadState.RUNNABLE;

        //TODO:为啥要引入线程组？
        public Worker(ThreadGroup group, String name) {
            super(group, name);
            System.out.println("线程:" + name + ",创建并就绪");
        }

        public ThreadState getThreadState() {
            return threadState;
        }

        public void setThreadState(ThreadState threadState) {
            this.threadState = threadState;
        }

        public void close() {
            this.setThreadState(ThreadState.DEAD);
            System.out.println("线程：" + getName() + ",销毁");
        }

        @Override
        public void run() {
            OUTER:
            //当线程未死亡,从任务队列中取出任务执行
            while (this.getThreadState() != ThreadState.DEAD) {
                Runnable runnable;
                synchronized (TASK_QUEUE) {
                    if (TASK_QUEUE.isEmpty()) {
                        //如果任务队列为空，进入阻塞状态，释放锁，进入TASK_QUEUE的等待队列中。
                        try {
                            this.setThreadState(ThreadState.BLOCKED);
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            System.out.println("接收中断请求");
                            //一旦接受到中断信号，立刻跳出循环，重新执行判断逻辑
                            break OUTER;
                        }
                    }
                    //取出队首任务
                    runnable = TASK_QUEUE.removeFirst();
                }
                //执行
                this.setThreadState(ThreadState.RUNNING);
                runnable.run();
            }
        }
    }
}
