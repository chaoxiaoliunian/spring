package com.sjqi.springmvc.handlermapping;

import com.sjqi.springmvc.handler.AddUserHandler;
import com.sjqi.springmvc.handler.DeleteUserHandler;
import com.sjqi.springmvc.handler.ModifyUserHandler;
import com.sjqi.springmvc.handlermapping.iface.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName SimpleHandlerMapping
 * @Description 简单的if else 判断网址，对应Handler
 * @Author sjqi
 * @Date 10:51 2019/4/9
 * @Version 1.0
 **/
public class SimpleHandlerMapping implements HandlerMapping {
    @Override
    public Object getHandler(HttpServletRequest request) {
        //获取请求URL
        String uri = request.getRequestURI();
        //判断
        if (uri.equals("/addUser")) {
            return new AddUserHandler();
        } else if (uri.equals("/deleteUser")) {
            return new DeleteUserHandler();
        }
        return null;
    }
}
