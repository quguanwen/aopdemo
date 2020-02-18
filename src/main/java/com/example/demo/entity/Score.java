package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * score
 * @author 
 */
@Data
public class Score implements Serializable {
    private Integer sId;

    private Integer cId;

    private Integer score;

    private Course course;

    private static final long serialVersionUID = 1L;

}