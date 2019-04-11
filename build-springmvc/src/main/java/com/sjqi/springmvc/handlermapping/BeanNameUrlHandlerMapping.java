package com.sjqi.springmvc.handlermapping;

import com.sjqi.springmvc.handler.AddUserHandler;
import com.sjqi.springmvc.handler.ModifyUserHandler;
import com.sjqi.springmvc.handlermapping.iface.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName BeanNameUrlHandlerMapping
 * @Description 根据Bean名称匹配Handler
 * @Author sjqi
 * @Date 11:08 2019/4/9
 * @Version 1.0
 **/
public class BeanNameUrlHandlerMapping implements HandlerMapping {
    @Override
    public Object getHandler(HttpServletRequest request) {
        //获取请求URL
        String uri = request.getRequestURI();
        //判断
        if (uri.equals("/modifyUser")) {
            return new ModifyUserHandler();
        }
        return null;
    }
}
