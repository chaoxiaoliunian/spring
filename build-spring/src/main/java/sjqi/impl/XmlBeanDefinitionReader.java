package sjqi.impl;

import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import sjqi.interf.BeanDefinitionRegistry;
import sjqi.interf.Environment;
import sjqi.interf.Resource;
import sjqi.interf.ResourceLoader;
import sjqi.util.XmlValidationModeDetector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName XmlBeanDefinitionReader
 * @Description 通过loadBeanDefinition 方法读取配置，封装成Documnet,将Documnet交给DefaultBeanDefinitionDocumentReader 读取成BeanDefinition
 * @Author sjqi
 * @Date 16:23 2019/3/28
 * @Version 1.0
 **/
public class XmlBeanDefinitionReader {
    private ErrorHandler errorHandler = null;
    //缓存上层作为参数传递过来的bean工厂，
    private BeanDefinitionRegistry registry;
    private DefaultDocumentLoader documentLoader = new DefaultDocumentLoader();

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry=registry;
    }

    protected int doLoadBeanDefinitions(InputSource inputSource, Resource resource) throws Exception {
        // 通过DOM4J加载解析XML文件，最终形成Document对象
        Document doc = doLoadDocument(inputSource, resource);
        // 通过对Document对象的操作，完成BeanDefinition的加载和注册工作
        return registerBeanDefinitions(doc, resource);

    }
    public int registerBeanDefinitions(Document doc, Resource resource)  {
        // 创建BeanDefinitionDocumentReader来解析Document对象，完成BeanDefinition解析
        DefaultBeanDefinitionDocumentReader documentReader =new  DefaultBeanDefinitionDocumentReader();
        // 获得容器中已经注册的BeanDefinition数量
        //int countBefore = getRegistry().getBeanDefinitionCount();
        //解析过程入口，BeanDefinitionDocumentReader只是个接口，具体的实现过程在DefaultBeanDefinitionDocumentReader完成
        documentReader.registerBeanDefinitions(doc,this.registry);
        // 统计新的的BeanDefinition数量
        return 0;//getRegistry().getBeanDefinitionCount() - countBefore;
    }
    private EntityResolver entityResolver;
    private ResourceLoader resourceLoader=new PathMatchingResourcePatternResolver();

    protected EntityResolver getEntityResolver() {
        if (this.entityResolver == null) {
            // Determine default EntityResolver to use.
            ResourceLoader resourceLoader = getResourceLoader();
            if (resourceLoader != null) {
                this.entityResolver = new ResourceEntityResolver(resourceLoader);
            } else {
                //this.entityResolver = new DelegatingEntityResolver(getBeanClassLoader());
            }
        }
        return this.entityResolver;
    }
    public ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }
    private boolean namespaceAware = false;

    public boolean isNamespaceAware() {
        return this.namespaceAware;
    }

    public static final int VALIDATION_AUTO = XmlValidationModeDetector.VALIDATION_AUTO;
    private int validationMode = VALIDATION_AUTO;

    public int getValidationMode() {
        return this.validationMode;
    }

    protected int getValidationModeForResource(Resource resource) {
        int validationModeToUse = getValidationMode();
        if (validationModeToUse != VALIDATION_AUTO) {
            return validationModeToUse;
        }
        //		// Peek into the file to look for DOCTYPE.
        //校验DOCTYPE  int detectedMode = detectValidationMode(resource);
        int detectedMode = XmlValidationModeDetector.VALIDATION_XSD;
        if (detectedMode != VALIDATION_AUTO) {
            return detectedMode;
        }
        // Hmm, we didn't get a clear indication... Let's assume XSD,
        // since apparently no DTD declaration has been found up until
        // detection stopped (before finding the document's root tag).
        return XmlValidationModeDetector.VALIDATION_XSD;
    }

    protected Document doLoadDocument(InputSource inputSource, Resource resource) throws Exception {
        return this.documentLoader.loadDocument(inputSource);
    }

    public Document loadDocument(InputSource inputSource, EntityResolver entityResolver,
                                 ErrorHandler errorHandler, int validationMode, boolean namespaceAware) throws Exception {

        DocumentBuilderFactory factory = createDocumentBuilderFactory(validationMode, namespaceAware);
        DocumentBuilder builder = createDocumentBuilder(factory, entityResolver, errorHandler);
        return builder.parse(inputSource);
    }

    private static final String SCHEMA_LANGUAGE_ATTRIBUTE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    private static final String XSD_SCHEMA_LANGUAGE = "http://www.w3.org/2001/XMLSchema";

    protected DocumentBuilderFactory createDocumentBuilderFactory(int validationMode, boolean namespaceAware)
            throws ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(namespaceAware);

        if (validationMode != XmlValidationModeDetector.VALIDATION_NONE) {
            factory.setValidating(true);
            if (validationMode == XmlValidationModeDetector.VALIDATION_XSD) {
                // Enforce namespace aware for XSD...
                factory.setNamespaceAware(true);
                try {
                    factory.setAttribute(SCHEMA_LANGUAGE_ATTRIBUTE, XSD_SCHEMA_LANGUAGE);
                } catch (IllegalArgumentException ex) {
                    ParserConfigurationException pcex = new ParserConfigurationException(
                            "Unable to validate using XSD: Your JAXP provider [" + factory +
                                    "] does not support XML Schema. Are you running on Java 1.4 with Apache Crimson? " +
                                    "Upgrade to Apache Xerces (or Java 1.5) for full XSD support.");
                    pcex.initCause(ex);
                    throw pcex;
                }
            }
        }

        return factory;
    }

    protected DocumentBuilder createDocumentBuilder(DocumentBuilderFactory factory,
                                                    EntityResolver entityResolver, ErrorHandler errorHandler)
            throws ParserConfigurationException {

        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        if (entityResolver != null) {
            docBuilder.setEntityResolver(entityResolver);
        }
        if (errorHandler != null) {
            docBuilder.setErrorHandler(errorHandler);
        }
        return docBuilder;
    }

    public int loadBeanDefinitions(Resource resource) {
        try {
            InputStream inputStream = resource.getInputStream();
            return doLoadBeanDefinitions(new InputSource(inputStream), resource);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
