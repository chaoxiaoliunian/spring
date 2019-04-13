package com.sjqi.ssm.springmvc.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MyExceptionResolver
 * @Description 自定义异常处理器
 * 当异常返回前端页面遇到乱码时：参考:https://www.cnblogs.com/crazyMeng/p/4974571.html
 * @Author sjqi
 * @Date 10:58 2019/4/12
 * @Version 1.0
 **/
public class MyExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        MyException myException = null;
        if (e instanceof MyException) {
            myException = (MyException) e;
        } else {
            myException = new MyException("未知错误");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(myException);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
