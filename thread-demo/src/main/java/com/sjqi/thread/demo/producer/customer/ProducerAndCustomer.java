package com.sjqi.thread.demo.producer.customer;

import java.time.LocalDate;

/**
 * @ClassName Producer
 * @Description 生产者-消费者：单生产者消费者
 * @Author sjqi
 * @Date 14:45 2019/4/30
 * @Version 1.0
 **/
public class ProducerAndCustomer {
    private int i;
    public final Object LOCK = new Object();
    public volatile boolean isProduced = false;

    public void produce() {
            synchronized (LOCK) {
                if (isProduced) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    i++;
                    System.out.println("生产者生产数据:" + i);
                    try {
                        Thread.sleep(1_000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    LOCK.notify();
                    isProduced = true;
                }
        }
    }

    public void custom() {
            synchronized (LOCK) {
                if (isProduced) {
                    System.out.println("消费者消费数据：" + i);
                    try {
                        Thread.sleep(1_000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    LOCK.notify();
                    isProduced = false;
                } else {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    public static void main(String[] args) {
        ProducerAndCustomer pc = new ProducerAndCustomer();
        Thread producer = new Thread(() -> {
            while(true) {
                pc.produce();
            }
        });
        producer.start();
        Thread customer = new Thread(() -> {
            while(true) {
                pc.custom();
            }
        });
        customer.start();
    }
}
