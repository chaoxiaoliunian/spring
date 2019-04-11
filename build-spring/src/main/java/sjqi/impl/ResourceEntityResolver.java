package sjqi.impl;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import sjqi.interf.Resource;
import sjqi.interf.ResourceLoader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;

/**
 * @ClassName ResourceEntityResolver
 * @Description TODO
 * @Author sjqi
 * @Date 11:47 2019/3/30
 * @Version 1.0
 **/
public class ResourceEntityResolver implements EntityResolver {
    public static final String DTD_SUFFIX = ".dtd";
    public static final String XSD_SUFFIX = ".xsd";
    private final EntityResolver dtdResolver;
    private final EntityResolver schemaResolver;
    private final ResourceLoader resourceLoader;


    public ResourceEntityResolver(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        this.dtdResolver = new BeansDtdResolver();
        this.schemaResolver = new PluggableSchemaResolver(resourceLoader.getClassLoader());
    }


    public String toString() {
        return "EntityResolver delegating .xsd to " + this.schemaResolver + " and " + ".dtd" + " to " + this.dtdResolver;
    }

    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        InputSource source = resolveEntity(publicId, systemId);
        if (source == null && systemId != null) {
            String resourcePath = null;

            try {
                String decodedSystemId = URLDecoder.decode(systemId, "UTF-8");
                String givenUrl = (new URL(decodedSystemId)).toString();
                String systemRootUrl = (new File("")).toURI().toURL().toString();
                if (givenUrl.startsWith(systemRootUrl)) {
                    resourcePath = givenUrl.substring(systemRootUrl.length());
                }
            } catch (Exception var8) {
                var8.printStackTrace();

                resourcePath = systemId;
            }

            if (resourcePath != null) {

                Resource resource = this.resourceLoader.getResource(resourcePath);
                source = new InputSource(resource.getInputStream());
                source.setPublicId(publicId);
                source.setSystemId(systemId);

            }
        }

        return source;
    }
}
