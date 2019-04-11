package sjqi.impl;

import java.io.InputStream;
import java.io.Reader;

/**
 * @ClassName InputSource
 * @Description TODO
 * @Author sjqi
 * @Date 17:19 2019/3/28
 * @Version 1.0
 **/
public class InputSource {
    public InputSource() {
    }

    public InputSource(String systemId) {
        setSystemId(systemId);
    }

    public InputSource(InputStream byteStream) {
        setByteStream(byteStream);
    }

    public InputSource(Reader characterStream) {
        setCharacterStream(characterStream);
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setByteStream(InputStream byteStream) {
        this.byteStream = byteStream;
    }

    public InputStream getByteStream() {
        return byteStream;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setCharacterStream(Reader characterStream) {
        this.characterStream = characterStream;
    }

    public Reader getCharacterStream() {
        return characterStream;
    }

    private String publicId;
    private String systemId;
    private InputStream byteStream;
    private String encoding;
    private Reader characterStream;


}
