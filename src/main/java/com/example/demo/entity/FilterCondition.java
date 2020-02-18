package com.example.demo.entity;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class FilterCondition implements Serializable {


    //TODO 分数区间
    @Min(value = 0, message = "分数范围输入有误")
    @Max(value = 100, message = "分数范围输入有误")
    private Long scoreMax;
    @Min(value = 0, message = "分数范围输入有误")
    @Max(value = 100, message = "分数范围输入有误")
    private Long scoreMin;

    //TODO 课程名称筛选
    private String courseName;

    //TODO 教师名称筛选
    private String teacherName;
}
