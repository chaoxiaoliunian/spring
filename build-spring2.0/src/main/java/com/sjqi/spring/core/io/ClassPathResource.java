package com.sjqi.spring.core.io;

import com.sjqi.spring.util.Assert;

import java.io.*;
import java.net.URL;

/**
 * @ClassName ClassPathResource
 * @Description 提供从类路径读取资源的能力
 * @Author sjqi
 * @Date 10:25 2019/4/2
 * @Version 1.0
 **/
public class ClassPathResource implements Resource {
    private String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this.path = path;
        this.classLoader = Thread.currentThread().getContextClassLoader();
    }


    /**
     * 根据当前的类路径+path 读取资源
     *
     * @return
     * @throws IOException
     */
    public InputStream getInputStream() throws IOException {
        Assert.notNull(path, "Path must not  be null");
        //将判空抛异常逻辑封装到业务逻辑中，增强内聚性
        InputStream in = this.classLoader.getResourceAsStream(path);
        if (null == in) {
            throw new FileNotFoundException(path + "not found");
        }
        return in;
    }

    public String getFilePath() {
        URL url = this.classLoader.getResource(this.path);
        return url.toString();
    }
}
