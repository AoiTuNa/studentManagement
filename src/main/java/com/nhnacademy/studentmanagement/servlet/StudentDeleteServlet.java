package com.nhnacademy.studentmanagement.servlet;

import com.nhnacademy.studentmanagement.exception.NoSerchStudentIdException;
import com.nhnacademy.studentmanagement.students.StudentRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "StudentDeleteServlet", urlPatterns = "/student/delete")
public class StudentDeleteServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException{
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if(!studentRepository.existById(id)){
            throw new NoSerchStudentIdException();
        }
        //todo get parameter  : id , id가 존재하지 않을경우 throw new RuntimeException("...")
        studentRepository.deleteById(id);
        String viewPath = "/student/list.do";
        req.setAttribute("view",viewPath);
        resp.sendRedirect(viewPath);
        //todo /student/list <-- redirect
    }
}
