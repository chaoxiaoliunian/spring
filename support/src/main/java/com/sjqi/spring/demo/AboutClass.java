package com.sjqi.spring.demo;

/**
 * @ClassName AboutClass
 * @Description 各种类型获取Class
 * @Author sjqi
 * @Date 13:29 2019/4/4
 * @Version 1.0
 * TODO:包装类型的源码
 **/
public class AboutClass {
    public static void main(String[] args) {
        //基本类型
        System.out.println(int.class);
        //包装类型
        System.out.println(Integer.class);
        //包装类型对应的基本类型
        System.out.println(Integer.TYPE);
        //class 是否为基本类型
        System.out.println(Integer.class.isPrimitive());

    }
}
