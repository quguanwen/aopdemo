package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * course
 * @author 
 */

@Data
public class Course implements Serializable {
    private Integer cId;

    private String cName;

    private Integer tId;

    private Teacher teacher;

    private static final long serialVersionUID = 1L;

}