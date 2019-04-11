package com.sjqi.spring.example;

import com.sjqi.spring.beans.factory.BeanFactory;
import com.sjqi.spring.beans.factory.XmlBeanFactory;
import com.sjqi.spring.core.io.ClassPathResource;
import com.sjqi.spring.core.io.Resource;
import com.sjqi.spring.example.model.Course;

import java.util.Map;

/**
 * @ClassName XmlBeanFactoryDemo
 * @Description XmlBeanFactory 的调用示例
 * @Author sjqi
 * @Date 9:32 2019/4/8
 * @Version 1.0
 **/
public class XmlBeanFactoryDemo {
    public static void main(String[] args) {
        ClassPathResource resource = new ClassPathResource("beans.xml");
        System.out.println(resource.getFilePath());
        //DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //DocumentBuilder builder = factory.newDocumentBuilder();
        //Document doc = builder.parse(new FileInputStream(resource.getFile()));
        XmlBeanFactory beanFactory = new XmlBeanFactory(resource);
        for (Map.Entry<String, Object> entry : beanFactory.getAllBeans().entrySet()) {

        }
    }
}
