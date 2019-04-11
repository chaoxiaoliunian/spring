package sjqi.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @ClassName PropertiesUtils
 * @Description TODO
 * @Author sjqi
 * @Date 12:05 2019/3/30
 * @Version 1.0
 **/
public class PropertiesLoaderUtils {
    public static Properties loadAllProperties(String resourceName, ClassLoader classLoader) throws IOException {
        ClassLoader classLoaderToUse = classLoader;
        if (classLoader == null) {
            classLoaderToUse = ClassUtils.getDefaultClassLoader();
        }

        Enumeration<URL> urls = classLoaderToUse != null ? classLoaderToUse.getResources(resourceName) : ClassLoader.getSystemResources(resourceName);
        Properties props = new Properties();

        while(urls.hasMoreElements()) {
            URL url = (URL)urls.nextElement();
            URLConnection con = url.openConnection();
            ResourceUtils.useCachesIfNecessary(con);
            InputStream is = con.getInputStream();

            try {
                if (resourceName.endsWith(".xml")) {
                    props.loadFromXML(is);
                } else {
                    props.load(is);
                }
            } finally {
                is.close();
            }
        }

        return props;
    }
}
