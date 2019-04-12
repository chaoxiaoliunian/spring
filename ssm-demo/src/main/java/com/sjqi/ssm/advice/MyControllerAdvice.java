package com.sjqi.ssm.advice;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyControllerAdvice
 * @Description 对所有的Controller 进行增强
 * @Author sjqi
 * @Date 10:20 2019/4/12
 * @Version 1.0
 **/
@ControllerAdvice
public class MyControllerAdvice {
    @ModelAttribute
    public Map<String, Object> putModelMap() {
        //应用到所有的@RequestMapping 在其执行前，把所有的返回值放入ModelMap中
        Map<String, Object> map = new HashMap<>();
        map.put("test", "test");
        System.out.println("Controller 增强：将参数放入ModelMap");
        return map;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        //应用到@RequestMapping，在其执行前，进行参数绑定
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        System.out.println("initBinder");
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleException(Exception e) {
        //应用到所有的@RequestMapping，在其抛出异常时指定。
        System.out.println("Controller 增强：异常处理，检测到异常消息：" + e.getMessage());
        return e.getMessage();
    }
}
