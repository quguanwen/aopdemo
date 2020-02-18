package com.example.demo.service;

import com.example.demo.configuration.exception.CustomException;
import com.example.demo.configuration.exception.CustomExceptionType;
import com.example.demo.entity.FilterCondition;
import com.example.demo.entity.Score;
import com.example.demo.entity.Student;
import com.example.demo.mapper.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public Long faculty() {
        return teacherMapper.countByExample(null);
    }

    @Override
    //查询有多少个张老师
    public Long selectBySurname() {
        // 创建查询的条件模板
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andTNameLike("张%");
        return teacherMapper.countByExample(teacherExample);
    }


    @Autowired
    StudentDetailsMapper studentDetailsMapper;

    /**
     * TODO 获取所有的学生列表
     *
     * @Param pageNum 第几页
     * @Param pageSize 第展示多少条
     */

    @Override
    public PageInfo<Student> selectStudentDetailsAll(int pageNum, int pageSize) {
        //TODO 分页
        PageHelper.startPage(1, 2);
        List<Student> list = studentDetailsMapper.selectStudentDetailsAll();
        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
        return pageInfo;
    }


    //TODO 获取学生详情列表,但是附带筛选条件
    @Override
    public List<Student> selectStudentDetailsAll(FilterCondition fc) {

        if (fc.getScoreMin() > fc.getScoreMax()) {
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR, "分数范围输入有误");
        }

        return studentDetailsMapper.selectStudentDetailsAllFilter(fc);
    }

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    ScoreMapper scoreMapper;

    //TODO 测试事务,新增一个学生,并增加他的成绩
    @Override
    @Transactional
    public void insertStudentAndScore(Student student) { //Student被mysql主键自动设置主键了!!
        //插入学生信息表
        studentMapper.insertSelective(student);
        //插入该学生的每门成绩表
        for (Score score : student.getListScore()
        ) {
            score.setSId(student.getSId());
            scoreMapper.insert(score);
        }
    }

}
