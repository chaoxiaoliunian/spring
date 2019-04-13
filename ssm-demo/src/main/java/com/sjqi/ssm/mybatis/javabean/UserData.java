package com.sjqi.ssm.mybatis.javabean;

/**
 * @ClassName UserData
 * @Description 用户类，对应用户表
 * @Author sjqi
 * @Date 19:59 2019/3/21
 * @Version 1.0
 **/
public class UserData {
    private int id;
    private String username;
    private String sex;
    private int age;
    private String addr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public UserData() {
    }

    public UserData(int id, String username, String sex, int age, String addr) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.age = age;
        this.addr = addr;
    }

    public UserData(String username, String sex, int age, String addr) {
        this.username = username;
        this.sex = sex;
        this.age = age;
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }
}
