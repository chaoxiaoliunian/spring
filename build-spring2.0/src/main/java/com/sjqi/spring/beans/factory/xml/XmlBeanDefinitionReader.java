package com.sjqi.spring.beans.factory.xml;

import com.sjqi.spring.beans.factory.support.BeanDefinitionRegistry;
import com.sjqi.spring.core.io.Resource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName XmlBeanDefinitionReader
 * @Description 把xml读取到内存中，调用具体的xml解析-注册逻辑
 * @Author sjqi
 * @Date 10:52 2019/4/2
 * @Version 1.0
 **/
public class XmlBeanDefinitionReader {
    BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    /**
     * 从xml中读取bean定义，并注册到BeanFactory中
     *
     * @param resource
     * @return
     */
    public int loadBeanDefinitions(Resource resource) {
        SAXReader saxReader = new SAXReader();
        Document dom4j = null;
        try {
            dom4j = saxReader.read(resource.getInputStream());
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return registerBeanDefinitions(dom4j);
    }

    int registerBeanDefinitions(Document dom4j) {
        BeanDefinitionDocumentReader bdDocReader = new BeanDefinitionDocumentReader();
        int beforeCount = registry.getBeanDefinitionCount();
        bdDocReader.registerBeans(dom4j, registry);
        int afterCount = registry.getBeanDefinitionCount();
        return afterCount - beforeCount;
    }

}
