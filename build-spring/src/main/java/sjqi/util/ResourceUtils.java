package sjqi.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ClassName ResourceUtils
 * @Description 只摘抄了ResourceUtils 中相关的部分方法。
 * @Author sjqi
 * @Date 16:00 2019/3/28
 * @Version 1.0
 **/
public abstract class ResourceUtils {
    public static final String CLASSPATH_URL_PREFIX = "classpath:";

    public static final String URL_PROTOCOL_FILE = "file";
    public static void useCachesIfNecessary(URLConnection con) {
        con.setUseCaches(con.getClass().getSimpleName().startsWith("JNLP"));
    }
    public static File getFile(URL resourceUrl, String description) throws FileNotFoundException {
        //Assert.notNull(resourceUrl, "Resource URL must not be null");
        if (!URL_PROTOCOL_FILE.equals(resourceUrl.getProtocol())) {
            throw new FileNotFoundException(
                    description + " cannot be resolved to absolute file path " +
                            "because it does not reside in the file system: " + resourceUrl);
        }
        try {
            return new File(toURI(resourceUrl).getSchemeSpecificPart());
        } catch (URISyntaxException ex) {
            // Fallback for URLs that are not valid URIs (should hardly ever happen).
            return new File(resourceUrl.getFile());
        }
    }

    public static URI toURI(URL url) throws URISyntaxException {
        return toURI(url.toString());
    }

    public static URI toURI(String location) throws URISyntaxException {
        return new URI(StringUtils.replace(location, " ", "%20"));
    }
}
