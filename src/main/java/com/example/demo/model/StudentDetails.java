package com.example.demo.model;

import com.example.demo.entity.Score;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StudentDetails implements Serializable {

    private Integer sId;

    private String sName;

    private Integer sAge;

    private String sSex;



}
