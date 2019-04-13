package com.sjqi.ssm.springmvc.controller;

import com.sjqi.ssm.springmvc.model.ParamsModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @ClassName BaseController
 * @Description 所有 cotroller 的父类
 * @Author sjqi
 * @Date 8:32 2019/4/11
 * @Version 1.0
 **/
public abstract class BaseController {
    @ModelAttribute("myUser")
    public ParamsModel dealModel(ParamsModel user, Model model) {
        //@ModelAttribute 修饰的方法会在所有请求之前执行,可以操作请求的model，但是user 不共享。
        //带有返回值的，会将返回值的小写key放入modelMap中。

        System.out.println("在所有的请求前执行,user:" + user.getName() + ",model:" + model.toString());
        user.setName("帅气sjqi");
        model.addAttribute("baseInfo", "我是你爸爸");
        user.setName("爸爸的名字");
        /**
         * Controller 种可以随时添加：request,response,session,input/outputStream,writer,reader,Model/ModelMap
         *Model和ModelMap 底层实现都是BindingAwareModelMap,作用是向页面传递数据。
         */
        return user;
    }
}
