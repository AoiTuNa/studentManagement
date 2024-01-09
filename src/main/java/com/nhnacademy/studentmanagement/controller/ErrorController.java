package com.nhnacademy.studentmanagement.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static javax.servlet.RequestDispatcher.*;
import static javax.servlet.RequestDispatcher.ERROR_STATUS_CODE;

public class ErrorController implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
//        req.setAttribute("status_code", req.getAttribute(ERROR_STATUS_CODE));
////        req.setAttribute("exception_type", req.getAttribute(ERROR_EXCEPTION_TYPE));
////        req.setAttribute("message", req.getAttribute(ERROR_MESSAGE));
////        req.setAttribute("exception", req.getAttribute(ERROR_EXCEPTION));
////        req.setAttribute("request_uri", req.getAttribute(ERROR_REQUEST_URI));
////        log.error("status_code:{}", req.getAttribute(ERROR_STATUS_CODE));
////        RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
////        rd.forward(req,resp);
////        return "/error.jsp";
    }
}
