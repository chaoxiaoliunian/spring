package com.sjqi.springmvc.handlermapping.iface;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName HandlerMapping
 * @Description 处理器分发类
 * @Author sjqi
 * @Date 10:36 2019/4/9
 * @Version 1.0
 **/
public interface HandlerMapping {
    Object getHandler(HttpServletRequest request);
}
