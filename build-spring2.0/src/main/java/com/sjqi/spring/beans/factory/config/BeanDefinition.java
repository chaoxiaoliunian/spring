package com.sjqi.spring.beans.factory.config;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BeanDefinition
 * @Description 对xml中bean配置的抽象
 * @Author sjqi
 * @Date 11:19 2019/4/2
 * @Version 1.0
 **/
public class BeanDefinition {
    //id和name都有，容器中使用id 作为键值，name 会作为一个别名；
    private String id;
    //如果不指定id 则会指定name 名称，如果name 也没有则会使用  class属性=》全路径
    private String name;
    //既可以直接存放一个明确的bean 的类型对象， 也可以存放bean 类型的的全路径
    private Object beanClass;
    //指定该bean的"父类",通常和abstract 一起使用：两者用来简化配置
    private String parenrt;
    //标记是否抽象，true 则只是用来简化xml配置，不会被创建。
    private boolean abstractFlag = false;
    //默认单例，原型; request,session,global session
    private String scope = "";
    //是否延迟初始化
    private boolean lazyInit = false;
    /**
     * 自动注入方式，默认不会自动注入
     * TODO:其他几种方式的研究
     */
    private int autowireMode = 0;
    //标记本bean 是否参与自动注入
    private boolean autowireCandidate = true;
    //当自动注入对应多个类型时，优先匹配标记为true的bean 而不是报错。
    private boolean primary = false;
    //工厂bean的id
    private String factoryBeanName;
    //工厂方法
    private String factoryMethodName;
    //初始化调用   TODO:构造方法的前？中？后？
    private String initMethod;
    //销毁之前调用 TODO:什么时候会销毁一个bean？
    private String destoryMethodName;

    //用来存放成员变量的key-value。对应配置中的 property 的name 和value
    //private MutablePropertyValues propertyValues;
    private final List<PropertyValue> propertyValueList = new ArrayList<>();
    /**
     * TODO: 其他待研究属性
     * private final Map<String, Object> attributes = new LinkedHashMap<>(0);
     * private int dependencyCheck = 0;
     * private String[] dependsOn;
     * private final Map<String, AutowireCandidateQualifier> qualifiers = new LinkedHashMap<>(0);
     * private ConstructorArgumentValues constructorArgumentValues;
     * private MethodOverrides methodOverrides;
     */

    public void setBeanClassName(String className) {
        this.beanClass = className;
    }

    public Object getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Object beanClass) {
        this.beanClass = beanClass;
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
}
