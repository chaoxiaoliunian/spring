package com.sjqi.ssm.springmvc.model;

import java.util.Date;

/**
 * @ClassName ParamsModel2
 * @Description 自定义参数绑定规则
 * @Author sjqi
 * @Date 9:36 2019/4/11
 * @Version 1.0
 **/
public class ParamsModel2 extends ParamsModel{
    private String myName;
    private int myAge;
    private Date myDate;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public int getMyAge() {
        return myAge;
    }

    public void setMyAge(int myAge) {
        this.myAge = myAge;
    }

    public Date getMyDate() {
        return myDate;
    }

    public void setMyDate(Date myDate) {
        this.myDate = myDate;
    }
}
