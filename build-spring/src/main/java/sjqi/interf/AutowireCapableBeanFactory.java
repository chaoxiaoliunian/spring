package sjqi.interf;

import java.util.Set;

/**
 * @ClassName AutoWiredBeanFactory
 * @Description 自动注入
 * @Author sjqi
 * @Date 10:10 2019/3/28
 * @Version 1.0
 **/
public interface AutowireCapableBeanFactory extends BeanFactory {
    Object applyBeanPostProcessorBeforeInitialization(Object existingBean, String beanName);

    Object applyBeanPostProcessorAfterInitialization(Object existingBean, String beanName);

    void applyBeanPropertyValues(Object existingBean, String beanName);

    Object autowire(Class<?> beanClass, int autoWireMode, boolean dependencyCheck);

    void autowireBean(Object existingBean);

    void autowireBeanProperties(Class<?> beanClass, int autoWireMode, boolean dependencyCheck);

    Object configureBean(Object existingBean, String beanName);

    Object createBean(Class<?> beanClass, int autoWireMode, boolean dependencyCheck);

    <T> T createBean(Class<T> beanClass);

    void destoryBean(Object existingBean);

    Object initializeBean(Object existingBean, String beanName);

    <T> NamedBeanHolder<T> resolveNamedBean(Class<T> requiredType);
//TODO ? 进一步了解源码
    //Object resolveDependency(DependencyDescriptor descriptor, @Nullable String requestingBeanName) throws BeansException;
//Object resolveDependency(DependencyDescriptor descriptor, @Nullable String requestingBeanName,
//                         @Nullable Set<String> autowiredBeanNames, @Nullable TypeConverter typeConverter) throws BeansException;

}
