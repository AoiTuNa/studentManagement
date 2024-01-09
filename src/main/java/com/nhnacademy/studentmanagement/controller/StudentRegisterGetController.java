package com.nhnacademy.studentmanagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentRegisterGetController implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/student/register.jsp";
    }
}
