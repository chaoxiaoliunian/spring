package com.sjqi.spring.demo.aop;

import com.sjqi.spring.model.User;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName AboutCglib
 * @Description cglib 入门案例
 * @Author sjqi
 * @Date 20:37 2019/4/5
 * @Version 1.0
 **/
public class AboutCglib implements MethodInterceptor {
    private Object obj;
    public  Object getInstance(Object obj){
        this.obj=obj;
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(this.obj.getClass());
        enhancer.setCallback(this);
        return  enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(method.getName().equals("printName")){
            System.out.println("cglib打印用户名");
        }
        methodProxy.invokeSuper(o,objects);
        return null;
    }

    public static void main(String[] args) {
        AboutCglib aboutCglib=new AboutCglib();
        User u=(User) aboutCglib.getInstance(new User());
        u.printName();

    }
}
