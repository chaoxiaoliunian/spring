package sjqi.interf;

/**
 * @ClassName NamedBeanHolder
 * @Description 组合：Bean名称 和 Bean实例
 * @Author sjqi
 * @Date 10:40 2019/3/28
 * @Version 1.0
 **/
public class NamedBeanHolder<T> {
    private final String beanName;
    private final T beanInstance;

    public NamedBeanHolder(String beanName, T beanInstance) {
        //Assert.notNull(beanName, "Bean name must not be null");
        this.beanName = beanName;
        this.beanInstance = beanInstance;
    }

    public String getBeanName() {
        return beanName;
    }

    public T getBeanInstance() {
        return beanInstance;
    }
}
