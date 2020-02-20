package com.example.demo.service;

import com.example.demo.entity.Teacher;
import com.example.demo.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherForRedisImpl implements TeacherForRedis {

    @Autowired
    TeacherMapper teacherMapper;

    /**
     * 执行该方法需要对两个缓存进行操作
     * 1.teacherAll集合类型直接删除
     * 2.teacher对应的对象也直接删除
     */
    @Caching(evict = {@CacheEvict(cacheNames = "teacherAll", allEntries = true),
            @CacheEvict(cacheNames = "teacher", key = "#teacher.getTId()")})
    @Override
    public Teacher createTeacher(Teacher teacher) {
        teacherMapper.insert(teacher);
        //TODO 这里操作容易迷惑 ,传过来的teacher没有id ,通过getId可以通过mysql自增主键拿到ID
        teacher.setTId(teacher.getTId());
        return teacher;
    }

    /**
     * 执行该方法需要对两个缓存进行操作
     * 1.teacherAll集合类型直接删除
     * 2.teacher对应的对象也直接删除
     */
    @Caching(evict = {@CacheEvict(cacheNames = "teacherAll", allEntries = true),
            @CacheEvict(cacheNames = "teacher", key = "#id")})
    @Override
    public void deleteTeacher(Long id) {
        teacherMapper.deleteByPrimaryKey(id.intValue());
    }

    /**
     * 执行该方法需要对两个缓存进行操作
     * 1.teacherAll集合类型直接删除 ,allEntries=true表示删除所有集合内容
     * 2.teacher对应的对象也直接删除
     */
    @Caching(evict = {@CacheEvict(cacheNames = "teacherAll", allEntries = true),
            @CacheEvict(cacheNames = "teacher", key = "#teacher.getTId()")})
    @Override
    public Teacher updateTeacher(Teacher teacher) {
        teacherMapper.updateByExample(teacher, null);
        return null;
    }

    /**
     * 查询对象操作,创建缓存
     */
    @Cacheable(value = "teacher", key = "#id")
    @Override
    public Teacher selectTeacher(Long id) {
        return teacherMapper.selectByPrimaryKey(id.intValue());
    }

    /**
     * 查询对象集合操作,创建缓存
     */
    @Cacheable(value = "teacherAll")
    @Override
    public List<Teacher> selectTeacherAll() {
        return teacherMapper.selectByExample(null);
    }
}
