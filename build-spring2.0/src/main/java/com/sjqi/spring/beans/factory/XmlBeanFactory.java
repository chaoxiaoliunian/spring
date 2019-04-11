package com.sjqi.spring.beans.factory;

import com.sjqi.spring.beans.factory.config.BeanDefinition;
import com.sjqi.spring.beans.factory.config.PropertyValue;
import com.sjqi.spring.beans.factory.config.TypeStringValue;
import com.sjqi.spring.beans.factory.support.BeanDefinitionRegistry;
import com.sjqi.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.sjqi.spring.core.io.Resource;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName XmlBeanFactory
 * @Description xml 配置文件bean 工厂
 * @Author sjqi
 * @Date 11:17 2019/4/2
 * @Version 1.0
 **/
public class XmlBeanFactory extends DefaultListableBeanFactory implements  BeanDefinitionRegistry {

    public Object getBean(String name) {
        //第一次调用的时候实现bean的初始化。
        if (beanMap.containsKey(name)) {
            return beanMap.get(name);
        }
        Object obj = null;
        BeanDefinition bd = beanDefinitionMap.get(name);
        obj = doCreateBean(bd);
        beanMap.put(name,obj);
        return obj;
    }

    public Object doCreateBean(BeanDefinition bd) {
        //TODO:解决循环依赖问题
        String beanClass = (String) bd.getBeanClass();
        Object obj = null;
        try {
            Class clazz = Class.forName(beanClass);
            obj = clazz.newInstance();
            for (PropertyValue propertyValue : bd.getPropertyValueList()) {
                Object value = null;
                if (propertyValue.getValue() instanceof TypeStringValue) {
                    //TODO:如何确定属性的类型传入内省赋值操作中
                    value =(String) ((TypeStringValue) propertyValue.getValue()).getValue();
                } else if (propertyValue.getValue() instanceof RuntimeException) {
                    value = getBean(propertyValue.getName());
                } else {
                    throw new RuntimeException("未覆盖的PropertyValue类型");
                }
                System.out.println("注入的属性:"+propertyValue.getName());
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyValue.getName(), clazz);
                Method m = propertyDescriptor.getWriteMethod();
                m.invoke(obj, value);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public XmlBeanFactory(Resource xmlResource) {
        /**
         * 钩子函数和不依赖return 的方式注册bean 反映出思路的升级：这个类就像一块积木，这个模块自身的功能
         * 全部在自己这里实现了，不可分割了。许多这样的模块共同拼凑出一个系统。而不是通过debug流程来编写系统。
         */
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(this);
        xmlReader.loadBeanDefinitions(xmlResource);
    }

    public <T> T getBean(String name, Class<T> requiredTye) {
        return (T) beanMap.get(name);
    }

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        //实现BeanDefinitionRegistry 接口逻辑，在加载BeanDifinition的时候被调用，用于向集合中注册一个BeanDifinition。
        System.out.println("registerBeanDefinition==========="+beanName);
        this.beanDefinitionMap.put(beanName, beanDefinition);
    }

    public int getBeanDefinitionCount() {
        return beanDefinitionMap.size();
    }
}
