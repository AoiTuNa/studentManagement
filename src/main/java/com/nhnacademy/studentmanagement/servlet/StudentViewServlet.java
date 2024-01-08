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
@WebServlet(name = "studentViewServlet", urlPatterns = "/student/view")
public class StudentViewServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(Objects.isNull(req.getParameter("id"))){
            log.info("Not have Id");
            RequestDispatcher dispatcher = req.getRequestDispatcher("student/list.jsp");
            dispatcher.forward(req,resp);
        }
        Student student = studentRepository.getStudentById(req.getParameter("id"));
        req.setAttribute("student",student);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/student/view.jsp");
        dispatcher.forward(req,resp);
    }

}
