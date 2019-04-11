package sjqi.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sjqi.interf.BeanDefinition;
import sjqi.interf.BeanDefinitionRegistry;
import sjqi.interf.Resource;
import sjqi.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName DefaultBeanDefinitionDocumentReader
 * @Description xml 标签解析逻辑
 * @Author sjqi
 * @Date 16:01 2019/3/29
 * @Version 1.0
 **/
public class DefaultBeanDefinitionDocumentReader {
    public int registerBeanDefinitions(Document doc, BeanDefinitionRegistry registry) {
        Element root = doc.getDocumentElement();
        parseBeanDefinitions(root, registry);

        return 0;
    }

    public static final String ID_ATTRIBUTE = "id";
    public static final String NAME_ATTRIBUTE = "name";
    public static final String MULTI_VALUE_ATTRIBUTE_DELIMITERS = ",; ";
    public static final String CLASS_ATTRIBUTE = "class";
    public static final String PARENT_ATTRIBUTE = "parent";
    private static final String SINGLETON_ATTRIBUTE = "singleton";
    public static final String SCOPE_ATTRIBUTE = "scope";
    public static final String ABSTRACT_ATTRIBUTE = "abstract";
    public static final String TRUE_VALUE = "true";
    public static final String LAZY_INIT_ATTRIBUTE = "lazy-init";
    public static final String DEFAULT_VALUE = "default";
    public static final String AUTOWIRE_ATTRIBUTE = "autowire";

    public static final String AUTOWIRE_CANDIDATE_ATTRIBUTE = "autowire-candidate";

    public static final String PRIMARY_ATTRIBUTE = "primary";

    public static final String DEPENDS_ON_ATTRIBUTE = "depends-on";

    public static final String INIT_METHOD_ATTRIBUTE = "init-method";

    public static final String DESTROY_METHOD_ATTRIBUTE = "destroy-method";

    public static final String FACTORY_METHOD_ATTRIBUTE = "factory-method";

    public static final String FACTORY_BEAN_ATTRIBUTE = "factory-bean";

    public static final String CONSTRUCTOR_ARG_ELEMENT = "constructor-arg";

    protected BeanDefinition parseDefaultElement(Element ele) {
        //TODO 完善BeanDefinition的创建
        BeanDefinition bd = new BeanDefinition();
        String id = ele.getAttribute(ID_ATTRIBUTE);
        // 获取bean的name
        String nameAttr = ele.getAttribute(NAME_ATTRIBUTE);

        List<String> aliases = new ArrayList<>();
        if (StringUtils.hasLength(nameAttr)) {
            String[] nameArr = StringUtils.tokenizeToStringArray(nameAttr, MULTI_VALUE_ATTRIBUTE_DELIMITERS);
            aliases.addAll(Arrays.asList(nameArr));
        }
        String beanName = id;
        if (!StringUtils.hasText(beanName) && !aliases.isEmpty()) {
            beanName = aliases.remove(0);
        }
        bd.setBeanName(beanName);
        String className = null;
        // 获取bean标签的class属性
        if (ele.hasAttribute(CLASS_ATTRIBUTE)) {
            className = ele.getAttribute(CLASS_ATTRIBUTE).trim();
        }
        bd.setBeanClass(className);
        String parent = null;
        // 获取bean标签的parent属性
        if (ele.hasAttribute(PARENT_ATTRIBUTE)) {
            parent = ele.getAttribute(PARENT_ATTRIBUTE);
        }

        // 解析<bean>标签的singleton属性
        if (ele.hasAttribute(SINGLETON_ATTRIBUTE)) {
        }
        // 解析<bean>标签的scope属性
        else if (ele.hasAttribute(SCOPE_ATTRIBUTE)) {
            bd.setScope(ele.getAttribute(SCOPE_ATTRIBUTE));
        }
//        // 解析<bean>标签的lazy-init属性
//        String lazyInit = ele.getAttribute(LAZY_INIT_ATTRIBUTE);
//        if (DEFAULT_VALUE.equals(lazyInit)) {
//            lazyInit = this.defaults.getLazyInit();
//        }
//        bd.setLazyInit(TRUE_VALUE.equals(lazyInit));
//
//        // 解析<bean>标签的autowire属性
//        String autowire = ele.getAttribute(AUTOWIRE_ATTRIBUTE);
//        bd.setAutowireMode(getAutowireMode(autowire));
//
//        // 解析<bean>标签的depends-on属性
//        if (ele.hasAttribute(DEPENDS_ON_ATTRIBUTE)) {
//            String dependsOn = ele.getAttribute(DEPENDS_ON_ATTRIBUTE);
//            bd.setDependsOn(StringUtils.tokenizeToStringArray(dependsOn, MULTI_VALUE_ATTRIBUTE_DELIMITERS));
//        }
//
////        // 解析<bean>标签的autowire-candidate属性
////        String autowireCandidate = ele.getAttribute(AUTOWIRE_CANDIDATE_ATTRIBUTE);
////        if ("".equals(autowireCandidate) || DEFAULT_VALUE.equals(autowireCandidate)) {
////            String candidatePattern = this.defaults.getAutowireCandidates();
////            if (candidatePattern != null) {
////                String[] patterns = StringUtils.commaDelimitedListToStringArray(candidatePattern);
////                bd.setAutowireCandidate(PatternMatchUtils.simpleMatch(patterns, beanName));
////            }
////        } else {
////            bd.setAutowireCandidate(TRUE_VALUE.equals(autowireCandidate));
////        }
//
//        // 解析<bean>标签的primary属性
//        if (ele.hasAttribute(PRIMARY_ATTRIBUTE)) {
//            bd.setPrimary(TRUE_VALUE.equals(ele.getAttribute(PRIMARY_ATTRIBUTE)));
//        }
//
//        // 解析<bean>标签的init-method属性
//        if (ele.hasAttribute(INIT_METHOD_ATTRIBUTE)) {
//            String initMethodName = ele.getAttribute(INIT_METHOD_ATTRIBUTE);
//            bd.setInitMethodName(initMethodName);
//        } else if (this.defaults.getInitMethod() != null) {
//            bd.setInitMethodName(this.defaults.getInitMethod());
//            bd.setEnforceInitMethod(false);
//        }
//
//        // 解析<bean>标签的destroy-method属性
//        if (ele.hasAttribute(DESTROY_METHOD_ATTRIBUTE)) {
//            String destroyMethodName = ele.getAttribute(DESTROY_METHOD_ATTRIBUTE);
//            bd.setDestroyMethodName(destroyMethodName);
//        } else if (this.defaults.getDestroyMethod() != null) {
//            bd.setDestroyMethodName(this.defaults.getDestroyMethod());
//            bd.setEnforceDestroyMethod(false);
//        }
//
//        // 解析<bean>标签的factory-method属性
//        if (ele.hasAttribute(FACTORY_METHOD_ATTRIBUTE)) {
//            bd.setFactoryMethodName(ele.getAttribute(FACTORY_METHOD_ATTRIBUTE));
//        }
//        // 解析<bean>标签的factory-bean属性
//        if (ele.hasAttribute(FACTORY_BEAN_ATTRIBUTE)) {
//            bd.setFactoryBeanName(ele.getAttribute(FACTORY_BEAN_ATTRIBUTE));
//        }
        //TODO:解析bean标签的子属性
        return bd;
    }

    public boolean nodeNameEquals(Node node, String desiredName) {
        return desiredName.equals(node.getNodeName()) || desiredName.equals(getLocalName(node));
    }

    public String getLocalName(Node node) {
        return node.getLocalName();
    }

    protected void parseBeanDefinitions(Element root, BeanDefinitionRegistry registry) {
        NodeList nl = root.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                //TODO 这里目前只加入bean的解析
                BeanDefinition bd = parseDefaultElement(ele);
                registry.registerBeanDefinition(bd.getBeanName(), bd);
            }
        }
    }
}
