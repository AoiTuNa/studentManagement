package com.nhnacademy.studentmanagement.controller;

import com.nhnacademy.studentmanagement.Annotations.RequestMapping;
import com.nhnacademy.studentmanagement.students.Student;
import com.nhnacademy.studentmanagement.students.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(value = "/student/update.do", method = RequestMapping.Method.GET)
public class StudentUpdateGetController implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");
        String id = request.getParameter("id");
        Student student = studentRepository.getStudentById(id);
        request.setAttribute("student",student);
        return "/student/register.jsp";
    }
}
