package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * teacher
 * @author 
 */
@Data
public class Teacher implements Serializable {

    private Integer tId;

    private String tName;

    private static final long serialVersionUID = 1L;


}