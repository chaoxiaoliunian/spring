package sjqi.impl;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import sjqi.util.CollectionUtils;
import sjqi.util.PropertiesLoaderUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName PluggableSchemaResolver
 * @Description TODO
 * @Author sjqi
 * @Date 12:00 2019/3/30
 * @Version 1.0
 **/
public class PluggableSchemaResolver implements EntityResolver {
    public static final String DEFAULT_SCHEMA_MAPPINGS_LOCATION = "META-INF/spring.schemas";
    private final ClassLoader classLoader;
    private final String schemaMappingsLocation;
    private volatile Map<String, String> schemaMappings;

    public PluggableSchemaResolver(ClassLoader classLoader) {
        this.classLoader = classLoader;
        this.schemaMappingsLocation = "META-INF/spring.schemas";
    }

    public PluggableSchemaResolver(ClassLoader classLoader, String schemaMappingsLocation) {
        this.classLoader = classLoader;
        this.schemaMappingsLocation = schemaMappingsLocation;
    }

    public org.xml.sax.InputSource resolveEntity(String publicId, String systemId) throws IOException {

        if (systemId != null) {
            String resourceLocation = (String)this.getSchemaMappings().get(systemId);
            if (resourceLocation != null) {
                ClassPathResource resource = new ClassPathResource(resourceLocation, this.classLoader);

                try {
                    org.xml.sax.InputSource source = new InputSource(resource.getInputStream());
                    source.setPublicId(publicId);
                    source.setSystemId(systemId);

                    return source;
                } catch (FileNotFoundException var6) {
                   var6.printStackTrace();
                }
            }
        }

        return null;
    }

    private Map<String, String> getSchemaMappings() {
        if (this.schemaMappings == null) {
            synchronized(this) {
                if (this.schemaMappings == null) {


                    try {
                        Properties mappings = PropertiesLoaderUtils.loadAllProperties(this.schemaMappingsLocation, this.classLoader);

                        Map<String, String> schemaMappings = new ConcurrentHashMap(mappings.size());
                        CollectionUtils.mergePropertiesIntoMap(mappings, schemaMappings);
                        this.schemaMappings = schemaMappings;
                    } catch (IOException var5) {
                        throw new IllegalStateException("Unable to load schema mappings from location [" + this.schemaMappingsLocation + "]", var5);
                    }
                }
            }
        }

        return this.schemaMappings;
    }

    public String toString() {
        return "EntityResolver using mappings " + this.getSchemaMappings();
    }
}
