package com.sjqi.spring.example.model;

import java.util.List;

/**
 * @ClassName Course
 * @Description 课程类
 * @Author sjqi
 * @Date 9:25 2019/4/2
 * @Version 1.0
 **/
public class Course {
    //名称
    private String name;
    //学分
    private int point;
    //老师
    private  Teacher teacher;
    //学生
    private List<Student> studentList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", point=" + point +
                ", teacher=" + teacher +
                ", studentList=" + studentList +
                '}';
    }
}
