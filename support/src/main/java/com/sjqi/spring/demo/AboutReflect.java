package com.sjqi.spring.demo;

import com.sjqi.spring.model.User;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName AboutReflect
 * @Description 反射相关的操作。
 * @Author sjqi
 * @Date 13:33 2019/4/4
 * @Version 1.0
 * TODO:反射相关的常见面试题列举与解答
 **/
public class AboutReflect {
    @Test
    public void testContructor() throws Exception {
        //测试构造方法
        Class c = Class.forName("com.sjqi.spring.model.User");
        //根据参数获取构造器,构造器必须是public 的
        Constructor constructor = c.getConstructor();
        User objStr = (User) constructor.newInstance();
        //调用私有的构造器
        Constructor constructor1 = c.getDeclaredConstructor(String.class, int.class);
        //如果当前类有访问权限则无需设置，否则必须设置
        constructor1.setAccessible(true);
        User objInt = (User) constructor1.newInstance("啊哈哈哈哈", 1);
    }

    @Test
    public void testMethod() throws Exception {
        //测试普通方法
        Class c = Class.forName("com.sjqi.spring.model.User");
        //只能调用普通方法
        Method m = c.getMethod("printName");
        m.invoke(c.newInstance());
        //可以调用私有方法,参数必须是正确的(包装类型不能直接转换)
        Method m1 = c.getDeclaredMethod("printUser", String[].class, int.class);
        m1.setAccessible(true);
        //调用方法必须传入正确的参数
        System.out.println(m1.invoke(c.newInstance(), new String[]{"啊哈哈哈"}, 10));
    }
    @Test
    public void testField() throws  Exception{
        Class c = Class.forName("com.sjqi.spring.model.User");
        Object user=c.newInstance();
        //测试类成员变量
        Field f=c.getDeclaredField("name");
        f.setAccessible(true);
        f.set(user,"啊哈哈哈");
        System.out.println(((User)user).printName());

    }
}
