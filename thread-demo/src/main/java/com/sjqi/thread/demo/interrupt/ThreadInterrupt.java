package com.sjqi.thread.demo.interrupt;

/**
 * @ClassName ThreadInterrupt
 * @Description 给出线程中断的案例
 * 线程中断原理：外部发送中断信号到线程内部，线程捕获到中断异常，然后手工退出程序的运行。
 * @Author sjqi
 * @Date 7:09 2019/4/30
 * @Version 1.0
 **/
public class ThreadInterrupt {
    public static final Object MONITOR = new Object();

    public static void main(String[] args) throws InterruptedException {
        test01();
    }

    public static void test01() throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    //System.out.println(">>>>"+this.isInterrupted());
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        System.out.println("收到打断信号");
                        e.printStackTrace();
                    }
//                    synchronized (MONITOR) {
//                        try {
//                            MONITOR.wait(10);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
                    System.out.println(">>>>");
                }
            }
        };
        t.start();
        Thread.sleep(1_000L);
        //线程的中断只是设置了一个信号，需要线程的内部接收打断信号才行。
        t.interrupt();

        //t.stop();


    }

}
