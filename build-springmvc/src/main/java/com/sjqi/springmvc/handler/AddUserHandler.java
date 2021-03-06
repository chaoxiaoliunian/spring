package com.sjqi.springmvc.handler;

import com.sjqi.springmvc.handler.iface.IHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName AddUserHandler
 * @Description 添加用户
 * @Author sjqi
 * @Date 9:50 2019/4/9
 * @Version 1.0
 **/
public class AddUserHandler implements IHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain;charset=utf-8");
        try {
            response.getWriter().write("新增一个用户");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
