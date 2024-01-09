package com.nhnacademy.studentmanagement.controller;

import com.nhnacademy.studentmanagement.students.Student;
import com.nhnacademy.studentmanagement.students.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class StudentListController implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");
        List<Student> studentList = studentRepository.getStudents();
        request.setAttribute("studentList",studentList);
        return "/student/list.jsp";
    }
}
