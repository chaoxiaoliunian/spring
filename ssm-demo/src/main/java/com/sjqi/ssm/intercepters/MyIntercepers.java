package com.sjqi.ssm.intercepters;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MyIntercepers
 * @Description SpringMVC 的拦截器是绑定在HandlerMapping 中的
 * 使用步骤：1.创建拦截器类；2.在xml中配置
 * @Author sjqi
 * @Date 11:39 2019/4/11
 * @Version 1.0
 **/
public class MyIntercepers implements HandlerInterceptor {
    /**
     * 执行请求之前进行认证，常用于：权限认证
     *
     * @param request
     * @param response
     * @param handler
     * @return true 为放行
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 通常权限认证逻辑如下：
         * 1.公共url放行;2.有session放行;3.不放行，跳转到登录界面
         *
         */
        String requestURI=request.getRequestURI();
        //if(requestURI.indexOf()){}
        String username=(String)request.getSession().getAttribute("username");
        //response.sendRedirect("login.jsp");
        System.out.println("preHandle");
        return true;
    }

    /**
     * 在返回ModelAndView之前调用，常用于：操作ModelAndView对象，将公共数据放到前台进行操作，统一指定视图
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    /**
     * 在执行完handler之后调用，常用于：统一异常处理，统一日志处理。
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
