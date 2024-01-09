package com.nhnacademy.studentmanagement.controller;

import com.nhnacademy.studentmanagement.students.Student;
import com.nhnacademy.studentmanagement.students.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class StudentViewController implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");
        if(Objects.isNull(request.getParameter("id"))){
            return "student/list.jsp";
        }
        Student student = studentRepository.getStudentById(request.getParameter("id"));
        request.setAttribute("student",student);
        return "/student/view.jsp";
    }
}
