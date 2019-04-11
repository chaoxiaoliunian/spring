package sjqi.impl;

import sjqi.interf.BeanDefinition;
import sjqi.interf.BeanDefinitionRegistry;
import sjqi.interf.BeanFactory;
import sjqi.interf.Resource;
import sjqi.util.ClassUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName XmlBeanFactory
 * @Description 读取xml 加载到ioc容器里，工厂需要实现注册接口，这样xml里的bean才能注册给工厂。
 * @Author sjqi
 * @Date 14:59 2019/3/28
 * @Version 1.0
 **/
public class XmlBeanFactory implements BeanFactory, BeanDefinitionRegistry {
    private BeanFactory parentBeanFactory;
    //用來存放BeanDefinition 的容器
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
    //读取xml到内存中，
    private final XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this);

    public XmlBeanFactory(Resource resource) {
        this(resource, null);
    }

    public XmlBeanFactory(Resource resource, BeanFactory parentBeanFactory) {
        //TODO 父工厂代表产生此工厂的工厂吗？
        this.parentBeanFactory = parentBeanFactory;
        this.reader.loadBeanDefinitions(resource);
    }

    public boolean containsBean(String name) {
        return false;
    }

    public Object getBean(String name) {
        BeanDefinition bd = beanDefinitionMap.get(name);
        String beanClass = (String) bd.getBeanClass();
        Object obj = null;
        try {
            Class<?> clazz = ClassUtils.forName(beanClass, Thread.currentThread().getContextClassLoader());
            //TODO: 利用反射创建bean 并设置bean的属性。
            Constructor constructor = clazz.getConstructors()[0];
            obj = constructor.newInstance();//实例化，得到一个对象 //Spring - bean -id
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public <T> T getBean(String name, Class<T> requiredType) {
        return null;
    }

    public Object getBean(String name, Object... args) {
        return null;
    }

    public <T> T getBean(Class<T> requiredType) {
        return null;
    }

    public <T> T getBean(Class<T> requiredType, Object... args) {
        return null;
    }

    public void registerAlias(String name, String alias) {

    }

    public void removeAlias(String alias) {

    }

    public boolean isAlias(String name) {
        return false;
    }

    public String[] getAliases(String name) {
        return new String[0];
    }

    public boolean isProtoType(String name) {
        return false;
    }

    public boolean isSingleType(String name) {
        return false;
    }

    public boolean isTypeMatch(String name, Class<?> typeToMatch) {
        return false;
    }

    public Class<?> getType(String name) {
        return null;
    }

    //============================================
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    public void removeBeanDefinition(String beanName) {

    }

    public BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionMap.get(beanName);
    }

    public boolean containsBeanDefinition(String beanName) {
        return false;
    }

    public String[] getBeanDefinitionNames() {
        return new String[0];
    }

    public int getBeanDefinitionCount() {
        return 0;
    }

    public boolean isBeanNameInUse(String beanName) {
        return false;
    }
}
