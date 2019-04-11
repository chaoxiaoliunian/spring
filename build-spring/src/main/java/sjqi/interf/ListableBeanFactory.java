package sjqi.interf;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @ClassName ListableBeanFactory
 * @Description 返回bean的集合
 * @Author sjqi
 * @Date 11:06 2019/3/28
 * @Version 1.0
 **/
public interface ListableBeanFactory extends BeanFactory {
    boolean containsBeanDefinitation(String beanName);

    int getBeanDefinitationCount();

    String[] getBeanDefinitationNames();

    //TODO ? 了解 ResolvableType  @Nullable
    //String[] getBeanNamesForType(ResolvableType type);
    String[] getBeanNamesForType(Class<?> type);

    String[] getBeanNamesForType(Class<?> type, boolean includeNonSingletons, boolean allowEagerInit);

    <T> Map<String, T> getBeansOfType(Class<T> type);

    <T> Map<String, T> getBeansOfType(Class<T> type, boolean includeNonSingletons, boolean allowEagerInit);

    String[] getBeanNamesForAnnotation(Class<? extends Annotation> annotationType);

    Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType);

    <A extends Annotation> A findAnnotationOnBean(String beanName, Class<A> annotationType);


}
