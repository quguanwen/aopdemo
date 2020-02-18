package com.example.demo.service;


import com.example.demo.entity.FilterCondition;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PersonService {

    //查询当前教师人数
    Long faculty();

    //查询当前教师的姓张的个数?
    Long selectBySurname();

    //列出所有的学生信息 ,包括他们的课程的老师 ,课程的成绩
    PageInfo<Student> selectStudentDetailsAll(int pageNum, int pageSize);

    //列出所有的学生信息 ,包括他们的课程的老师 ,课程的成绩
    List<Student> selectStudentDetailsAll(FilterCondition fc);

    //事务新增,新增一个学生,同时新增它三门成绩
    void insertStudentAndScore(Student student);

}
