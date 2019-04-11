package com.sjqi.ssm.controller;

import com.sjqi.ssm.model.ParamsModel;
import com.sjqi.ssm.model.ParamsModel2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName UserServlet
 * @Description 用户Controller，匹配对应的url。
 * @Author sjqi
 * @Date 10:04 2019/4/10
 * @Version 1.0
 **/
//用于匹配url，推荐这个注解放到类上面，将url划分模块
@RequestMapping(value = {"/user", "/users"})
//封装了@Component,是对MVC 中的C更加明确的标记
@Controller
public class UserController extends BaseController {
    /**
     * 展示当返回值为String 的时候,如何进行参数绑定和拼装返回消息
     *http://localhost/user/getUsersBy?name=sjqi&age=16&birthday=2018-09-20
     * @param user  普通的POJO类，会自动根据名称进行参数绑定。
     * @param model springmvc 自动创建，用来向jsp返回数据,通过${msg}获取
     * @return 返回值代表返回给前端的页面
     */
    @GetMapping(value = "getUsersBy", params = {"name", "age", "birthday"})
    //封装了RequestMapping,参数params 的字符串是不带语义的严格匹配
    public String getUsersBy(ParamsModel2 user, Model model) {
        //TODO:Model和ModelMap和ModelAndView间的区别
        model.addAttribute("msg", "前端穿过来的名称:" + user.getName() + ",年龄：" + user.getAge() + "生日：" + user.getBirthday());
        //请求跳转，model参数能够被jsp接收
        return "forward:getHello";
        //请求重定向，model参数会作为url一部分，返回给前端
        //return "redirect:getHello";
    }

    @GetMapping(value = "getHello")
    public String getHello(Model model) {
        //最终返回一个jsp
        return "hello";
    }

    @RequestMapping("getString")
    //必须加上@ResponseBody，否则默认返回的是jsp。
    public String getString() {
        //返回一个字符串
        return "测试返回字符串";
    }

    /**
     * 展示当返回值为 void 的时候如何处理前端请求
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @GetMapping(value = "getUsersBy2", params = {"name", "age=16"})
    public void getUsersBy(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        //请求转发，前端url不变
        //request.getRequestDispatcher("getUsersBy").forward(request,response);
        //请求跳转，返回httpcode 302,前端url发生变化
        //response.sendRedirect("getUsersBy?name=" + name + "&age=" + age);
        //返回json
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        String json = "{\"msg\":\"返回消息\",\"name\":\"" + name + "\",\"age\":\"" + age + "\"}";
        response.getWriter().write(json);
    }
//TODO:跨域，mock测试，异常处理，乱码解决。整合mybatis(SpringJDBC)结合手写框架进一步思考。
}
