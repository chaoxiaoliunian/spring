package com.sjqi.ssm.controller;

import com.sjqi.ssm.model.ParamsModel;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.TimeZone;
import java.util.UUID;

/**
 * @ClassName UserController2
 * @Description 展示@RestController 的用法，
 * 或者可以拆成@Controller 加在类上,@ResponseBody 加在方法上。
 * 注解@ResponseBody:返回值直接写入http报文体中，不加则代表返回值是一个请求路径。
 * @Author sjqi
 * @Date 16:37 2019/4/10
 * @Version 1.0
 **/
@RestController
@RequestMapping("responseBody")
public class UserController2 {
    @RequestMapping(value = "uploadFile", produces = "text/plain;charset=utf-8")
    public String uploadFile(@RequestParam("uploadFile") MultipartFile file, HttpSession session) throws IOException {
        if (null == file) {
            return "文件不能为空";
        }
        String fileName = file.getOriginalFilename();
        System.out.println("上传文件的名称:" + fileName);
        if (StringUtils.isEmpty(file)) {
            return "文件名不能为空";
        }
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        ServletContext servletContext = session.getServletContext();
        String filePath = servletContext.getContextPath();
        String newFileName = UUID.randomUUID() + fileSuffix;
        File newFile = new File(filePath + newFileName);
        file.transferTo(newFile);
        return "上传成功,服务器路径：" + newFile.getAbsolutePath();
    }

    @GetMapping(value = "returnString", produces = "text/plain;charset=utf-8")
    //produces 直接指定了响应头
    public String getString() {
        return "返回给前端的值";
    }

    /**
     * 这个用来过滤请求头
     *
     * @RequestMapping(value = "/cons", consumes = {
     * "application/JSON",
     * "application/XML"
     * })
     */
    @GetMapping("returnPOJO")
    public ParamsModel getPOJO() {
        //自动将响应头设置为:application/json;charset=utf-8
        ParamsModel paramsModel = new ParamsModel();
        paramsModel.setName("sjqi");
        paramsModel.setAge(20);
        return paramsModel;
    }

    @RequestMapping("{id}/{name}")
    public ParamsModel queryUserById(@PathVariable Integer id, @PathVariable String name) {
       //测试 @PathVariable从url中读取参数 http://localhost/responseBody/27/sjqi
        ParamsModel paramsModel = new ParamsModel();
        paramsModel.setName(name);
        paramsModel.setAge(id);
        LocalDate localDate = LocalDate.now();
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zoneId).toInstant();
        paramsModel.setBirthday(Date.from(instant));
        return paramsModel;
    }
    /**
     * resultful uri 表现资源 http method 表现操作。
     *TODO:进一步体会restful 的细节，了解servlet中的filter 细节
     * TODO:进一步了解跨域实现原理，利用手写框架实现跨域。
     */
}
