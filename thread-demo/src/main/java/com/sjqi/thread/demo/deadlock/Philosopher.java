package com.sjqi.thread.demo.deadlock;

/**
 * @ClassName Philosopher
 * @Description 演示哲学家就餐问题
 * @Author sjqi
 * @Date 14:12 2019/4/30
 * @Version 1.0
 **/
public class Philosopher extends Thread {
    //哲学家编号0-4
    private int index;
    //筷子0-4
    public static final Object[] CHOPSTICKS = new Object[]{new Object(), new Object(), new Object(), new Object(), new Object()};

    //i号哲学家的左手边是i号筷子，右手边是（i+1）%5号筷子。
    public Philosopher(int index) {
        this.index = index;
    }

    public static void main(String[] args) {
        Philosopher p01 = new Philosopher(0);
        Philosopher p02 = new Philosopher(1);
        Philosopher p03 = new Philosopher(2);
        Philosopher p04 = new Philosopher(3);
        Philosopher p05 = new Philosopher(4);

        p01.start();
        p02.start();
        p03.start();
        p04.start();
        p05.start();

    }

    @Override
    public void run() {
        while (true) {
            synchronized (CHOPSTICKS[index]) {
                System.out.println("哲学家：" + index + ",拿起左手边的筷子");
                synchronized (CHOPSTICKS[(index + 1) % 5]) {
                    System.out.println("哲学家：" + index + ",拿起右手边筷子");
                    System.out.println("哲学家，" + index + ",吃完饭，放下筷子");
                }
            }
        }
    }
}
