package com.nhnacademy.studentmanagement.students;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
@Getter
public class Student implements Serializable {
    //TODO 일단 Setter써보고 문제있으면 바꾸자구요!!
    public enum Gender{
        M,F
    }
    private String id;
    private String name;
    private Gender gender;
    private int age;
    private final LocalDateTime createdAt;

    public Student (){
        this.createdAt = LocalDateTime.now();
    }

    public Student (String id,String name,Gender gender, int age){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.createdAt = LocalDateTime.now();
    }
}
