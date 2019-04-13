package com.sjqi.ssm.springmvc.model;

import java.util.Date;

/**
 * @ClassName ParamsModel
 * @Description
 * @Author sjqi
 * @Date 12:57 2019/4/10
 * @Version 1.0
 **/
public class ParamsModel {
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
