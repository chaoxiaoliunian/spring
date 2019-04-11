package com.sjqi.springmvc.handler.iface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName IHandler
 * @Description Handler类的处理接口，用于规范Handler类的行为，比如:防止doHandler类的命名出错。
 * @Author sjqi
 * @Date 9:50 2019/4/9
 * @Version 1.0
 **/
public interface IHandler {
    void handleRequest(HttpServletRequest request, HttpServletResponse response);
}
