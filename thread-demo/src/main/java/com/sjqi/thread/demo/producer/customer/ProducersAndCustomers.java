package com.sjqi.thread.demo.producer.customer;

/**
 * @ClassName ProducersAndCustomers
 * @Description 多生产者多消费者, notify 时不确定唤醒改锁上等待队列中的哪一项，会导致所有线程都处于阻塞状态。
 * @Author sjqi
 * @Date 17:11 2019/4/30
 * @Version 1.0
 **/
public class ProducersAndCustomers {
    private int i;
    public final Object LOCK = new Object();
    public volatile boolean isProduced = false;

    public void produce() {
        synchronized (LOCK) {
            //判断条件需要改成while
            while (isProduced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
            System.out.println("生产者生产数据:" + i);
            try {
                Thread.sleep(1_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //一定要使用notifyAll 否则会导致程序假死
            LOCK.notifyAll();
            isProduced = true;
        }
    }

    public void custom() {
        synchronized (LOCK) {
            while (isProduced) {
                System.out.println("消费者消费数据：" + i);
                try {
                    Thread.sleep(1_000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LOCK.notifyAll();
                isProduced = false;
            }
            try {
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        ProducersAndCustomers pc = new ProducersAndCustomers();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    pc.produce();
                }
            }).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    pc.custom();
                }
            }).start();
        }

    }
}
