package sjqi.interf;

import sjqi.util.ResourceUtils;

/**
 * @ClassName ResourceLoader
 * @Description 只是一个资源的加载器，Spring 喜欢为类或资源额外定义一个加载器，将资源和操作拆分
 * @Author sjqi
 * @Date 16:35 2019/3/28
 * @Version 1.0
 **/
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = ResourceUtils.CLASSPATH_URL_PREFIX;

    Resource getResource(String location);

    ClassLoader getClassLoader();

}
