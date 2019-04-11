package com.sjqi.spring.core.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName Resource
 * @Description 对资源进行统一抽象，定义读取资源的能力。
 * @Author sjqi
 * @Date 10:22 2019/4/2
 * @Version 1.0
 **/
public interface Resource {
    InputStream getInputStream() throws IOException;
}
