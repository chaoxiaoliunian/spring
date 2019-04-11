package com.sjqi.spring.beans.factory.xml;

import com.sjqi.spring.beans.factory.config.BeanDefinition;
import com.sjqi.spring.beans.factory.config.PropertyValue;
import com.sjqi.spring.beans.factory.config.RuntimeBeanReference;
import com.sjqi.spring.beans.factory.config.TypeStringValue;
import com.sjqi.spring.beans.factory.support.BeanDefinitionRegistry;
import com.sjqi.spring.util.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;

import java.util.Iterator;
import java.util.List;

/**
 * @ClassName BeanDefinitionDocumentReader
 * @Description 解析xml文件，创建BeanDefinition，调用具体的注册逻辑。
 * @Author sjqi
 * @Date 11:08 2019/4/2
 * @Version 1.0
 **/
public class BeanDefinitionDocumentReader {
    /**
     * 根据配置，创建BeanDefinition 对象，调用相关注册方法进行注册
     *
     * @param dom4j
     * @param registry
     */
    void registerBeans(Document dom4j, BeanDefinitionRegistry registry) {
        //TODO 改造成委托模式解析xml
        Element beans = dom4j.getRootElement();
        List<Element> list = beans.elements();
        for (Element bean : list) {
            String className = bean.attributeValue("class");
            String id = bean.attributeValue("id");

            //TODO:增加其他属性的解析逻辑。
            BeanDefinition bd = new BeanDefinition();
            bd.setBeanClassName(className);
            parseProperties(bean, bd);

            registry.registerBeanDefinition(id, bd);

        }
    }

    /**
     * 解析bean标签下的properties
     *
     * @param bean
     * @param bd
     */
    public void parseProperties(Element bean, BeanDefinition bd) {
        List<Element> properties = bean.elements();
        for (Element property : properties) {
            String name = property.attributeValue("name");
            Object value = parsePropetyValue(property);
            PropertyValue propertyValue = new PropertyValue(name, value);
            bd.getPropertyValueList().add(propertyValue);
        }
    }

    public Object parsePropetyValue(Element property) {
        //TODO:目前只支持value 和ref 方式的配置，待添加sub-element方式的配置。
        String value = property.attributeValue("value");
        String ref = property.attributeValue("ref");
        boolean hasValue = (null != value);
        boolean hasRef = (null != ref);
        if (hasValue && hasRef) {
            throw new RuntimeException("is only allowed to contain either 'ref' attribute OR 'value' ");
        }
        if (hasRef) {
            return new RuntimeBeanReference(ref);
        } else if (hasValue) {
            return new TypeStringValue(value);
        } else {
            throw new RuntimeException("配置文件缺少value或者ref属性");
        }
    }
}
