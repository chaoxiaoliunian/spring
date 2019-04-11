package com.sjqi.spring.model;

import java.util.Date;

/**
 * @ClassName JavaUser
 * @Description 用于测试内省的JavaBean（有getter,setter方法，符合Java命名规范。setXxx  setXXX）
 * 参考：https://blog.csdn.net/wodeyuer125/article/details/40352477
 * @Author sjqi
 * @Date 15:01 2019/4/4
 * @Version 1.0
 **/
public class JavaUser {
    private String name;
    private int age;
    private Date birthday;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
