package com.sjqi.thread.demo.interrupt;

/**
 * @ClassName DamenInterrupt
 * @Description 自定义守护线程用于执行业务逻辑，主线程则接收中断信号。
 * 常用于暴力退出线程。
 * @Author sjqi
 * @Date 11:19 2019/4/30
 * @Version 1.0
 **/
public class DaemonInterrupt {
    private Thread executeThread;

    public void execute(Runnable runnable) {
        this.executeThread = new Thread(() -> {
            Thread runner = new Thread(runnable);
            runner.setDaemon(true);
            runner.start();
            try {
                //!!!!!注意，join必须放到线程的run内部才是自己等待自己，否则就是外部线程等待本线程推出了
                this.executeThread.join();
            } catch (InterruptedException e) {
                System.out.println(this.executeThread.getName() + ",捕获到中断信号，成功退出");
            }
        });
        this.executeThread.start();

    }

    public void shutDown() {
        this.executeThread.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        DaemonInterrupt thread=new DaemonInterrupt();
        thread.execute(()->{
            while (true){
                //模拟一个很耗时的不能捕获中断信号的IO
                System.out.println(">>>>>>");
                try {
                    Thread.sleep(1_000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread.sleep(5_000L);
        thread.shutDown();
    }
}
