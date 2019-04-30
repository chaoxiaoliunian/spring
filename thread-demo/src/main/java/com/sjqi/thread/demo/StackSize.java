package com.sjqi.thread.demo;

/**
 * @ClassName StackSize
 * @Description 演示栈大小
 * @Author sjqi
 * @Date 8:49 2019/4/30
 * @Version 1.0
 **/
public class StackSize {
    private static int counter = 0;
    private int[] array = new int[1024];

    public static void main(String[] args) {
//        try {
//            add(0);
//        }catch (Exception e){
//            System.out.println("异常不打印"+counter);
//        }catch (Error e){
//            System.out.println("Error会打印"+counter);
//        }
        Thread t = new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    add(0);
                } catch (Error e) {
                    System.out.println(counter);
                }
                System.out.println("aa");
            }

            private void add(int index) {
                counter++;
                add(index++);
            }
        }, "Test", 1 << 24);
        t.start();
//指定栈大小,这个参数是高度依赖平台的，在有的平台上不起作用。
    }

//    public static void add(int i) {
//        counter++;
//        add(i++);
//    }

}
