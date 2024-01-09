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
@WebServlet(name = "studentUpdateServlet", urlPatterns = "/student/update")
public class StudentUpdateServlet extends HttpServlet {
    private StudentRepository studentRepository;
    private Student student;
    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = (StudentRepository)config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stId = req.getParameter("id");
        if(Objects.isNull(stId)){
            log.error("뭔가 잘못되었음 이름 어디감 ?");
        }
        student = studentRepository.getStudentById(stId);


        req.setAttribute("student",student);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/student/register.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO null check
        student.setName(req.getParameter("name"));
        student.setGender(Student.Gender.valueOf(req.getParameter("gender")));
        student.setAge(Integer.parseInt(req.getParameter("age")));
        studentRepository.update(student);
        String viewPath = "/student/list.do";
        req.setAttribute("view",viewPath);
        resp.sendRedirect(viewPath);
    }
}
