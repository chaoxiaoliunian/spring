package com.sjqi.ssm.springmvc.controller;

import com.sjqi.ssm.mybatis.javabean.UserData;
import com.sjqi.ssm.service.IUserDataDao;
import com.sjqi.ssm.springmvc.exception.MyException;
import com.sjqi.ssm.springmvc.model.ParamsModel;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private IUserDataDao userDataDao;

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
    public UserData getPOJO() {
        //自动将响应头设置为:application/json;charset=utf-8
        return userDataDao.selectByPrimaryKey(2);
    }

    @RequestMapping(value = "{id}/{name}")
    public ParamsModel queryUserById(@PathVariable Integer id, @PathVariable String name) throws MyException {
        //测试 @PathVariable从url中读取参数 http://localhost/responseBody/27/sjqi
        if (id < 16) {
            //测试自定义异常：http://localhost/responseBody/15/sjqi
            throw new MyException("id不能小于16");
        }
        ParamsModel paramsModel = new ParamsModel();
        paramsModel.setName(name);
        paramsModel.setAge(id);
        LocalDate localDate = LocalDate.now();
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zoneId).toInstant();
        paramsModel.setBirthday(Date.from(instant));
        return paramsModel;
    }
}
