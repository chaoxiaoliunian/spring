package com.sjqi.thread.demo.observer;

/**
 * @ClassName ObserverableRunnable
 * @Description 一个可被监听的线程
 * @Author sjqi
 * @Date 21:59 2019/5/8
 * @Version 1.0
 **/
public abstract class ObservableRunnable implements Runnable {
    private LifeCycleListener lifeCycleListener;
    private ThreadState threadState;

    public ObservableRunnable(LifeCycleListener lifeCycleListener) {
        this.lifeCycleListener = lifeCycleListener;
    }

    public LifeCycleListener getLifeCycleListener() {
        return lifeCycleListener;
    }

    public void setLifeCycleListener(LifeCycleListener lifeCycleListener) {
        this.lifeCycleListener = lifeCycleListener;
    }

    public ThreadState getThreadState() {
        return threadState;
    }

    public void setThreadState(ThreadState threadState) {
        this.threadState = threadState;
    }


    public enum ThreadState {
        RUNNING, ERROR, DONE;
    }

    public static class RunnableEvent {
        private Thread thread;
        private ThreadState threadState;
        private Throwable throwable;

        public RunnableEvent(Thread thread, ThreadState threadState, Throwable throwable) {
            this.thread = thread;
            this.threadState = threadState;
            this.throwable = throwable;
        }

        public Thread getThread() {
            return thread;
        }

        public ThreadState getThreadState() {
            return threadState;
        }

        public Throwable getThrowable() {
            return throwable;
        }
    }
}
