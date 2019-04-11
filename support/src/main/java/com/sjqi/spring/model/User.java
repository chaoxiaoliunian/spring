package com.sjqi.spring.model;

/**
 * @ClassName User
 * @Description 用于测试反射的用户类,是一个POJO
 * @Author sjqi
 * @Date 13:57 2019/4/4
 * @Version 1.0
 **/
public class User {
    private String name;
    private int age;

    private User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public User() {
    }
    private String printUser(String[] name,int age){
        this.name=name[0];
        this.age=age;
        System.out.println(this.name+"=="+this.age);
        return "success";
    }
    public String printName(){
        System.out.println(name);
        return "success";
    }

}
