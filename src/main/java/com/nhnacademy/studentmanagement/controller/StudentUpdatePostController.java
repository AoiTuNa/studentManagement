package com.nhnacademy.studentmanagement.controller;

import com.nhnacademy.studentmanagement.Annotations.RequestMapping;
import com.nhnacademy.studentmanagement.students.Student;
import com.nhnacademy.studentmanagement.students.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(value = "/student/update.do", method = RequestMapping.Method.POST)
public class StudentUpdatePostController implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");
        Student student = studentRepository.getStudentById(request.getParameter("id"));
        student.setName(request.getParameter("name"));
        student.setGender(Student.Gender.valueOf(request.getParameter("gender")));
        student.setAge(Integer.parseInt(request.getParameter("age")));
        studentRepository.update(student);
        return "redirect:/student/list.do";

    }
}
