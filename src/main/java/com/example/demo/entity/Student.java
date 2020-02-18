package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * student
 * @author 
 */
@Data
public class Student implements Serializable {
    private Integer sId;

    private String sName;

    private Integer sAge;

    private String sSex;

    private String registration;

    private List<Score> listScore;

    private static final long serialVersionUID = 1L;

}