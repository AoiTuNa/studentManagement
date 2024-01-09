package com.nhnacademy.studentmanagement.servlet;

import com.nhnacademy.studentmanagement.students.Student;
import com.nhnacademy.studentmanagement.students.StudentRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@WebServlet(name = "studentRegisterServlet", urlPatterns = "/student/register")
public class StudentRegisterServlet extends HttpServlet {

    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException{
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("/student/register.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if(Objects.isNull(request.getParameter("id"))||Objects.isNull(request.getParameter("name"))||Objects.isNull(request.getParameter("gender"))||Objects.isNull(request.getParameter("age"))){
            RequestDispatcher rd = request.getRequestDispatcher("/student/register.jsp");
            rd.forward(request,response);
        }
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        Student.Gender gender = Student.Gender.valueOf(request.getParameter("gender"));
        int age = Integer.parseInt(request.getParameter("age"));

        studentRepository.save(new Student(id,name,gender,age));
        String viewPath = "/student/list.do";
        request.setAttribute("view",viewPath);
        response.sendRedirect(viewPath);
    }
}
