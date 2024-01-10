package com.nhnacademy.studentmanagement.controller;

import com.nhnacademy.studentmanagement.Annotations.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(value = "/student/register.do",method = RequestMapping.Method.GET)
public class StudentRegisterGetController implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/student/register.jsp";
    }
}
