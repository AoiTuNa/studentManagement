package com.nhnacademy.studentmanagement.controller;

import com.nhnacademy.studentmanagement.students.Student;
import com.nhnacademy.studentmanagement.students.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class StudentRegisterPostController implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository = (StudentRepository)request.getServletContext().getAttribute("studentRepository");
        if(Objects.isNull(request.getParameter("id"))||Objects.isNull(request.getParameter("name"))||
        Objects.isNull(request.getParameter("gender"))||Objects.isNull(request.getParameter("age"))){
            return "/student/register.jsp";
        }
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        Student.Gender gender = Student.Gender.valueOf(request.getParameter("gender"));
        int age = Integer.parseInt(request.getParameter("age"));
        studentRepository.save(new Student(id,name,gender,age));
        return "/student/list.do";
    }
}
