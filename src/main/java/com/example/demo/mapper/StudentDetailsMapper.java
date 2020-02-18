package com.example.demo.mapper;

import com.example.demo.entity.FilterCondition;
import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentDetailsMapper {

    List<Student> selectStudentDetailsAllFilter(@Param("FC") FilterCondition fc);

    List<Student> selectStudentDetailsAll();
}
