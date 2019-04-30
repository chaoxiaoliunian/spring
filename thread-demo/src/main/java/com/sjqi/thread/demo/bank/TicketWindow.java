package com.sjqi.thread.demo.bank;

/**
 * @ClassName TicketWindow
 * @Description 叫号窗口
 * @Author sjqi
 * @Date 8:12 2019/4/30
 * @Version 1.0
 **/
public class TicketWindow extends Thread {
    private String name;
    public static final int MAX = 50;
    private static int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index < MAX) {
            System.out.println(name + ",当前叫号：" + (index++));
        }
    }

}
