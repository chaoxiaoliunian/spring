package sjqi.interf;

/**
 * @ClassName BeanDefinitionRegistry
 * @Description 定义BeanDefinition 相关操作
 * @Author sjqi
 * @Date 16:24 2019/3/28
 * @Version 1.0
 **/
public interface BeanDefinitionRegistry {
    void registerAlias(String name, String alias);

    void removeAlias(String alias);

    boolean isAlias(String name);

    String[] getAliases(String name);


    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    void removeBeanDefinition(String beanName);

    BeanDefinition getBeanDefinition(String beanName);

    boolean containsBeanDefinition(String beanName);

    String[] getBeanDefinitionNames();

    int getBeanDefinitionCount();

    boolean isBeanNameInUse(String beanName);
}
