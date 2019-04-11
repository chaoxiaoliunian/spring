package sjqi.interf;

/**
 * @ClassName Environment
 * @Description TODO
 * @Author sjqi
 * @Date 16:40 2019/3/28
 * @Version 1.0
 **/
public interface Environment {
    boolean containsProperty(String key);

    String getProperty(String key);

    String getProperty(String key, String defaultValue);

    <T> T getProperty(String key, Class<T> targetType);

    <T> T getProperty(String key, Class<T> targetType, T defaultValue);

    String getRequiredProperty(String key) throws IllegalStateException;

    <T> T getRequiredProperty(String key, Class<T> targetType) throws IllegalStateException;

    String resolvePlaceholders(String text);

    String resolveRequiredPlaceholders(String text) throws IllegalArgumentException;

    //===========================================

    String[] getActiveProfiles();

    String[] getDefaultProfiles();

    boolean acceptsProfiles(String... profiles);
}
