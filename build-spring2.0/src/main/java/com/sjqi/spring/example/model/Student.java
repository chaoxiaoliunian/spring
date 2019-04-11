package com.sjqi.spring.example.model;

/**
 * @ClassName Student
 * @Description 学生类
 * @Author sjqi
 * @Date 9:25 2019/4/2
 * @Version 1.0
 **/
public class Student {
    //姓名
    private String name;
    //年龄
    private int age;

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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
