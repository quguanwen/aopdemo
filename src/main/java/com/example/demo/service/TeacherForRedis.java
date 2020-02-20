package com.example.demo.service;

import com.example.demo.entity.Teacher;


import java.util.List;

public interface TeacherForRedis {

    //增加一个老师
    Teacher createTeacher(Teacher teacher);

    //删除一个老师
    void deleteTeacher(Long id);

    //修改一个老师
    Teacher updateTeacher(Teacher teacher);

    //查询一个老师
    Teacher selectTeacher(Long id);

    //查询老师列表
    List<Teacher> selectTeacherAll();

}
