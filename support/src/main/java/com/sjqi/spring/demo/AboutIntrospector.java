package com.sjqi.spring.demo;

import com.sjqi.spring.model.JavaUser;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.jupiter.api.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @ClassName AboutIntrospector [in 戳 s  bai ke ter ]
 * @Description 内省相关测试
 * @Author sjqi
 * @Date 15:19 2019/4/4
 * @Version 1.0
 **/
public class AboutIntrospector {
    /**
     * 内省机制是，jdk利用反射封装的bean操作api,bean 指的是经典JavaBean。
     */
    @Test
    public void testJavaApi() throws Exception {
        //测试java提供的原生api
        JavaUser javaUser = new JavaUser();
        //根据属性名称获取读写方法
        PropertyDescriptor propDesc = new PropertyDescriptor("name", JavaUser.class);
        Method method = propDesc.getWriteMethod();
        method.invoke(javaUser, "啊哈哈哈");
        Method method1 = propDesc.getReadMethod();
        System.out.println(method1.invoke(javaUser));

        //遍历bean 的信息
        BeanInfo beanInfo = Introspector.getBeanInfo(JavaUser.class);
        PropertyDescriptor[] ps = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor p : ps) {
            System.out.println(p.getName()+"=="+p.getDisplayName());
        }
    }
    @Test
    public void testBeanUtils() throws Exception{
        //TODO:阅读BeanUtils的源码，了解bean copy的api以及其他api
        //测试 apache BeansUtils API
        JavaUser javaUser=new JavaUser();
        BeanUtils.setProperty(javaUser,"age",10);
        System.out.println(javaUser.getAge());
        //BeanUtils内部把属性转换成String 来返回
        System.out.println(BeanUtils.getProperty(javaUser,"age").getClass());
        //propertyutil 按照原来的类型进行返回。
        System.out.println(PropertyUtils.getProperty(javaUser,"age").getClass());
        System.out.println();
        Date date=new Date();
        date.setTime(10000);
        BeanUtils.setProperty(javaUser,"birthday",date);
        //支持级联的方式访问
        System.out.println(BeanUtils.getProperty(javaUser,"birthday.time"));
    }
}
