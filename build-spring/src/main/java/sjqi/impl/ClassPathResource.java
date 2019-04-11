package sjqi.impl;

import sjqi.interf.Resource;
import sjqi.util.ClassUtils;
import sjqi.util.ResourceUtils;
import sjqi.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

/**
 * @ClassName ClassPathResource
 * @Description 精简版的配置文件读取，只实现了读取xml相关的方法。
 * @Author sjqi
 * @Date 15:21 2019/3/28
 * @Version 1.0
 **/
public class ClassPathResource implements Resource {
    private final String path;
    private ClassLoader classLoader;
    private Class<?> clazz;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        String pathToUse = StringUtils.cleanPath(path);
        if (pathToUse.startsWith("/")) {
            pathToUse = pathToUse.substring(1);
        }

        this.path = pathToUse;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    public boolean exists() {
        return false;
    }

    public URL getURL() throws IOException {
        URL url = this.resolveURL();
        if (url == null) {
            throw new FileNotFoundException(this.getDescription() + " cannot be resolved to URL because it does not exist");
        } else {
            return url;
        }
    }

    protected URL resolveURL() {
        if (this.clazz != null) {
            return this.clazz.getResource(this.path);
        } else {
            return this.classLoader != null ? this.classLoader.getResource(this.path) : ClassLoader.getSystemResource(this.path);
        }
    }

    public URI getURI() throws IOException {
        return null;
    }

    public File getFile() throws IOException {
        URL url = this.getURL();
        return ResourceUtils.getFile(url, this.getDescription());
    }

    public long contentLength() throws IOException {
        return 0;
    }

    public long lastModified() throws IOException {
        return 0;
    }

    public Resource createRelative(String relativePath) throws IOException {
        return null;
    }

    public String getFilename() {
        return null;
    }

    public String getDescription() {
        StringBuilder builder = new StringBuilder("class path resource [");
        String pathToUse = path;
        if (this.clazz != null && !pathToUse.startsWith("/")) {
            builder.append(ClassUtils.classPackageAsResourcePath(this.clazz));
            builder.append('/');
        }
        if (pathToUse.startsWith("/")) {
            pathToUse = pathToUse.substring(1);
        }
        builder.append(pathToUse);
        builder.append(']');
        return builder.toString();
    }

    public InputStream getInputStream() throws IOException {
        //用于XmlBeanDefinitionReader 中的loadBeanDifinitions 方法
        InputStream is;
        if (this.clazz != null) {
            is = this.clazz.getResourceAsStream(this.path);
        } else if (this.classLoader != null) {
            is = this.classLoader.getResourceAsStream(this.path);
        } else {
            is = ClassLoader.getSystemResourceAsStream(this.path);
        }
        if (is == null) {
            throw new FileNotFoundException(getDescription() + " cannot be opened because it does not exist");
        }
        return is;
    }
}
