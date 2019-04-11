package sjqi.util;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName CollectionUtils
 * @Description TODO
 * @Author sjqi
 * @Date 12:06 2019/3/30
 * @Version 1.0
 **/
public class CollectionUtils {
    public static <K, V> void mergePropertiesIntoMap( Properties props, Map<K, V> map) {
        if (props != null) {
            for (Enumeration<?> en = props.propertyNames(); en.hasMoreElements();) {
                String key = (String) en.nextElement();
                Object value = props.get(key);
                if (value == null) {
                    // Allow for defaults fallback or potentially overridden accessor...
                    value = props.getProperty(key);
                }
                map.put((K) key, (V) value);
            }
        }
    }
}
