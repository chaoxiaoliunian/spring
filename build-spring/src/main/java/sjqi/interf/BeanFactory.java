package sjqi.interf;

/**
 * @ClassName BeanFactory
 * @Description bean工厂的老祖宗
 * @Author sjqi
 * @Date 9:17 2019/3/28
 * @Version 1.0
 **/
public interface BeanFactory {
    boolean containsBean(String name);

    Object getBean(String name);

    <T> T getBean(String name, Class<T> requiredType);

    Object getBean(String name, Object... args);

    <T> T getBean(Class<T> requiredType);

    <T> T getBean(Class<T> requiredType, Object... args);

    String[] getAliases(String name);

    boolean isProtoType(String name);

    boolean isSingleType(String name);

    boolean isTypeMatch(String name, Class<?> typeToMatch);

    Class<?> getType(String name);
    //TODO ? 干嘛的
    // boolean isTypeMatch(String name, ResolvableType typeToMatch) throws NoSuchBeanDefinitionException;

}
