package com.example.demo.iocdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private String age;
}
