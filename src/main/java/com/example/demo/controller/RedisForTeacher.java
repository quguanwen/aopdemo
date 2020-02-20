package com.example.demo.controller;

import com.example.demo.entity.AjaxResponse;
import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherForRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisForTeacher {

    @Autowired
    TeacherForRedis teacherForRedis;

    @PostMapping("/teachers")
    public AjaxResponse createTeacher(@RequestBody Teacher teacher) {
        teacherForRedis.createTeacher(teacher);
        return AjaxResponse.success();
    }

    @DeleteMapping("/teachers/{id}")
    public AjaxResponse deleteTeacher(@PathVariable Long id) {
        teacherForRedis.deleteTeacher(id);
        return AjaxResponse.success();
    }

    @PutMapping("/teachers")
    public AjaxResponse updateTeacher(@RequestBody Teacher teacher) {
        teacherForRedis.updateTeacher(teacher);
        return AjaxResponse.success();
    }

    @GetMapping("/teachers/{id}")
    public AjaxResponse selectTeacher(@PathVariable Long id) {
        return AjaxResponse.success(teacherForRedis.selectTeacher(id));
    }

    @GetMapping("/teachers")
    public AjaxResponse selectTeacherAll() {
        return AjaxResponse.success(teacherForRedis.selectTeacherAll());
    }

}
