package com.sjqi.spring.demo.aop;

/**
 * @ClassName AboutAop
 * @Description Aop相关操作样例
 * @Author sjqi
 * @Date 16:09 2019/4/4
 * @Version 1.0
 **/
public class AboutAop {
    /**
     * 原理参考：https://www.cnblogs.com/xiaoxiao7/p/6057724.html
     * aop可以在：编译器，运行期字节码加载前修改字节码，字节码加载后动态生成中介类/代理类(字节码)
     * aop 5种实现方式：静态植入，动态代理，cglib生成目标类子类,类加载器，字节码转换
     *
     */

    public static void main(String[] args) {
        Float a=1.0f;
        int i02=590;
        Integer d=Integer.valueOf(590);
        Integer e=new Integer(590);
        System.out.println(d==e);
    }
    public static int test(int b){
        try{
            return b+=10;
        }finally {
             b+=10;
        }
    }
}
