package com.sjqi.spring.example.model;

/**
 * @ClassName Teacher
 * @Description 教师
 * @Author sjqi
 * @Date 9:28 2019/4/2
 * @Version 1.0
 **/
public class Teacher {
    //姓名
    private  String name;
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
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
