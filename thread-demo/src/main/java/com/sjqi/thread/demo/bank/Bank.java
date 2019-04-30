package com.sjqi.thread.demo.bank;

/**
 * @ClassName Bank
 * @Description 多线程模拟银行叫号，涉及知识点：thread的初步使用。
 * @Author sjqi
 * @Date 8:11 2019/4/30
 * @Version 1.0
 **/
public class Bank {
    public static void main(String[] args) {
        TicketWindow t1=new TicketWindow("一号窗口");
        t1.start();
        TicketWindow t2=new TicketWindow("二号号窗口");
        t2.start();
        TicketWindow t3=new TicketWindow("三号窗口");
        t3.start();

    }
}
