package com.example.demo.controller;

import com.example.demo.entity.AjaxResponse;
import com.example.demo.entity.FilterCondition;
import com.example.demo.entity.Student;
import com.example.demo.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/teacherNum")
    public AjaxResponse teacherNum() {
        return AjaxResponse.success(personService.faculty());
    }

    @GetMapping("/getTeacherBySurname")
    public AjaxResponse getTeacherBySurname() {
        return AjaxResponse.success(personService.selectBySurname());
    }

    //TODO 带条件的接口
    @GetMapping("/getStudentDetailAllFilter")
    public AjaxResponse getStudentDetailAll(@Valid @RequestBody FilterCondition fc) {
        return AjaxResponse.success(personService.selectStudentDetailsAll(fc));
    }

    //TODO 不带条件的接口
    @GetMapping("/getStudentDetailAll")
    public AjaxResponse getStudentDetailAll(@RequestParam int pageNum, @RequestParam int pageSize) { //两个参数都要参数的
        return AjaxResponse.success(personService.selectStudentDetailsAll(pageNum, pageSize));
    }

    //TODO 测试事务
    @PostMapping("/createStudentAndScore")
    public AjaxResponse createStudentAndScore(@RequestBody Student student) {
        personService.insertStudentAndScore(student);
        return AjaxResponse.success();
    }


}
