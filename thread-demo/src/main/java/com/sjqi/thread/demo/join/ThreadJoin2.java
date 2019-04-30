package com.sjqi.thread.demo.join;

/**
 * @ClassName ThreadJoin2
 * @Description join 的超时
 * @Author sjqi
 * @Date 9:26 2019/4/30
 * @Version 1.0
 **/
public class ThreadJoin2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            try {
                Thread.sleep(10_1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t1.join(100);
        System.out.println("asasas");
        //一些嵌入式的server 启动后会以守护线程的方式运行，当main线程退出后会导致server 关闭
        //可以使用自己等待自己的方式。
        Thread.currentThread().join();
    }
}
