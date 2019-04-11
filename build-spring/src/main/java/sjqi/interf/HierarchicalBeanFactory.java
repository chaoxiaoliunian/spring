package sjqi.interf;

/**
 * @ClassName HierarchicalBeanFactory
 * @Description 分级的  hi ra ki col
 * @Author sjqi
 * @Date 10:03 2019/3/28
 * @Version 1.0
 **/
public interface HierarchicalBeanFactory extends BeanFactory {
    /**
     * 获取父工厂
     * @return
     */
    BeanFactory getParentBeanFactory();

    /**
     * 判断本地工厂有没有
     * @param name
     * @return
     */
    boolean containsLocalBean(String name);
}
