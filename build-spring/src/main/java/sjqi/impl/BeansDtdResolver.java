package sjqi.impl;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import sjqi.interf.Resource;

import java.io.IOException;

/**
 * @ClassName BeansDtdResolver
 * @Description TODO
 * @Author sjqi
 * @Date 11:58 2019/3/30
 * @Version 1.0
 **/
public class BeansDtdResolver implements EntityResolver {
    private static final String DTD_EXTENSION = ".dtd";
    private static final String DTD_FILENAME = "spring-beans-2.0";
    private static final String DTD_NAME = "spring-beans";

    public BeansDtdResolver() {
    }

    public org.xml.sax.InputSource resolveEntity(String publicId, String systemId) throws IOException {
        if (systemId != null && systemId.endsWith(".dtd")) {
            int lastPathSeparator = systemId.lastIndexOf(47);
            int dtdNameStart = systemId.indexOf("spring-beans", lastPathSeparator);
            if (dtdNameStart != -1) {
                String dtdFile = "spring-beans-2.0.dtd";


                try {
                    Resource resource = new ClassPathResource(dtdFile, this.getClass().getClassLoader());
                    org.xml.sax.InputSource source = new InputSource(resource.getInputStream());
                    source.setPublicId(publicId);
                    source.setSystemId(systemId);

                    return source;
                } catch (IOException var8) {
                   var8.printStackTrace();
                }
            }
        }

        return null;
    }

    public String toString() {
        return "EntityResolver for spring-beans DTD";
    }
}
