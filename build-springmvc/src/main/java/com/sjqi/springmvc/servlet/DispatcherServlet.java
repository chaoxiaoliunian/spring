package com.sjqi.springmvc.servlet;

import com.sjqi.spring.beans.factory.BeanFactory;
import com.sjqi.spring.beans.factory.XmlBeanFactory;
import com.sjqi.spring.core.io.ClassPathResource;
import com.sjqi.springmvc.handler.AddUserHandler;
import com.sjqi.springmvc.handler.DeleteUserHandler;
import com.sjqi.springmvc.handler.ModifyUserHandler;
import com.sjqi.springmvc.handler.iface.IHandler;
import com.sjqi.springmvc.handlermapping.iface.HandlerMapping;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DispatcherServlet
 * @Description 请求分发servlet
 * 分发机制：单一servlet 将请求分配给不同的handler处理。
 * @Author sjqi
 * @Date 9:33 2019/4/9
 * @Version 1.0
 **/
public class DispatcherServlet extends FrameworkServlet {
    private final List<HandlerMapping> handlerList = new ArrayList<>();

    @Override
    public void init(ServletConfig config) {
        String contextConfigLocation = config.getInitParameter("contextConfigLocation");
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(contextConfigLocation));
        for (Map.Entry<String, Object> entry : factory.getAllBeans().entrySet()) {
            if (entry.getValue() instanceof HandlerMapping) {
                handlerList.add((HandlerMapping) entry.getValue());
            }
        }
    }

    @Override
    public void doDispatcher(HttpServletRequest request, HttpServletResponse response) {
        //请求分发
        Object handler = getHandler(request);
        if (handler == null) {
            throw new RuntimeException("未覆盖的网址："+request.getRequestURI());
        }
        //执行处理器中的方法
        if (handler instanceof AddUserHandler) {
            ((AddUserHandler) handler).handleRequest(request, response);
        } else if (handler instanceof DeleteUserHandler) {
            ((DeleteUserHandler) handler).handleRequest(request, response);
        } else if (handler instanceof ModifyUserHandler) {
            ((ModifyUserHandler) handler).handleRequest(request, response);
        } else {
            throw new RuntimeException("未覆盖的网址");
        }
    }

    public Object getHandler(HttpServletRequest request) {
        //有可能存在多个HandlerMapping （多个Handler匹配策略）
        System.out.println("+++===="+request.getRequestURI());
        for (HandlerMapping hm : handlerList) {
            Object obj = hm.getHandler(request);
            if (obj != null) {
                return obj;
            }
        }
        return null;
    }
}
