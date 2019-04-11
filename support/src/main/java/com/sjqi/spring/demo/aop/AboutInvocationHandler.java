package com.sjqi.spring.demo.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName AboutInvocationHandler
 * @Description 动态代理demo
 * @Author sjqi
 * @Date 9:47 2019/4/5
 * @Version 1.0
 **/
public class AboutInvocationHandler {
    /**
     * 原理参考：https://www.cnblogs.com/gonjan-blog/p/6685611.html
     * https://www.cnblogs.com/xiaoxiao7/p/6057724.html
     * <p>
     * 动态代理底层原理：JVM异步创建了一个实现了业务接口的中介类并放入缓存，这个中介类持有我们定义的代理类，
     * 我们调用的时候调用的是这个中介类，中介类调用代理类的invoke，invoke通过反射调用方法。
     * 缺点：1.由于中介类是实现接口，动态代理技术只能针对有接口的那些类进行操作。
     *       2.代理类过多会导致大量生成代理类文件，导致永久代full gc，可将永久代扩大。
     */
    public static void main(String[] args) {
        SoftwareEngineer java = new JavaSoftwareEngineer();
        SoftwareEngineer php = new PhpSoftwareEngineer();
        InvocationHandler enginnerProxy = new EnginnerProxy(java);
        Class<EnginnerProxy>[] classArr = new Class[]{SoftwareEngineer.class};
        ClassLoader classLoader = java.getClass().getClassLoader();
        SoftwareEngineer softwareEngineer = (SoftwareEngineer) Proxy.newProxyInstance(classLoader, classArr, enginnerProxy);
        softwareEngineer.buildSoftware();
    }
}

class EnginnerProxy implements InvocationHandler {
    private Object obj;

    public EnginnerProxy(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //动态代理，前后插入的功能放在这里。
        System.out.println("分析需求");
        Object result = method.invoke(obj, args);
        System.out.println("交付项目");
        return result;
    }
}

class JavaSoftwareEngineer implements SoftwareEngineer {
    public void buildSoftware() {
        System.out.println("构建java程序");
    }
}

class PhpSoftwareEngineer implements SoftwareEngineer {
    public void buildSoftware() {
        System.out.println("构建php垃圾");
    }
}

interface SoftwareEngineer {
    void buildSoftware();
}
