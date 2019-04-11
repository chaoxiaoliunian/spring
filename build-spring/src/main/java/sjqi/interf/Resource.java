package sjqi.interf;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

/**
 * @ClassName Resources
 * @Description 对资源的抽象
 * @Author sjqi
 * @Date 15:04 2019/3/28
 * @Version 1.0
 **/
public interface Resource {
    boolean exists();

    //default boolean isReadable() {return true;}
    //default boolean isOpen() {return false;}
    //	default boolean isFile() {return false;}
    URL getURL() throws IOException;

    URI getURI() throws IOException;

    File getFile() throws IOException;

    // default ReadableByteChannel readableChannel() throws IOException {		return Channels.newChannel(getInputStream());}
    long contentLength() throws IOException;

    long lastModified() throws IOException;

    Resource createRelative(String relativePath) throws IOException;

    String getFilename();

    String getDescription();

    InputStream getInputStream() throws IOException;


}
