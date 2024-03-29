package com.nhnacademy.studentmanagement.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.nhnacademy.studentmanagement.controller.*;
import static javax.servlet.RequestDispatcher.*;

@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX="redirect";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 공통 처리 - 응답 content-type, character encoding 지정.
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        try {
            Command servletCommand = resolveCommand(req.getServletPath(),req.getMethod());
            String view = servletCommand.execute(req,resp);
            //todo 실제 로직을 처리할 Command(Controller) 결정, String view = command.execute() ...

            if (view.startsWith(REDIRECT_PREFIX)) {
                log.error("redirect-url : {}", view.substring(REDIRECT_PREFIX.length() + 1));
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()+1));
                //todo `redirect:`로 시작하면 redirect 처리.
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher(view);
                dispatcher.include(req,resp);
                //todo redirect 아니면 JSP에게 view 처리를 위임하여 그 결과를 include 처리.

            }
        }catch (Exception ex){
            //공통 error 처리
            req.setAttribute("status_code", req.getAttribute(ERROR_STATUS_CODE));
            req.setAttribute("exception_type", req.getAttribute(ERROR_EXCEPTION_TYPE));
            req.setAttribute("message", req.getAttribute(ERROR_MESSAGE));
            req.setAttribute("exception", req.getAttribute(ERROR_EXCEPTION));
            req.setAttribute("request_uri", req.getAttribute(ERROR_REQUEST_URI));
            log.error("status_code:{}", req.getAttribute(ERROR_STATUS_CODE));
            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req,resp);
        }

    }

    private Command resolveCommand(String servletPath, String method){
        Command command = null;
        if("/student/list.do".equals(servletPath) && "GET".equalsIgnoreCase(method) ){
            command = new StudentListController();
        }
        if("/student/delete.do".equals(servletPath) && "POST".equalsIgnoreCase(method)){
            command = new StudentDeleteController();
        }
        if("/student/register.do".equals(servletPath) && "GET".equalsIgnoreCase(method)){
            command = new StudentRegisterGetController();
        }
        if("/student/register.do".equals(servletPath) && "POST".equalsIgnoreCase(method)){
            command = new StudentRegisterPostController();
        }
        if("/student/update.do".equals(servletPath) && "GET".equalsIgnoreCase(method)){
            command = new StudentUpdateGetController();
        }
        if("/student/update.do".equals(servletPath) && "POST".equalsIgnoreCase(method)){
            command = new StudentUpdatePostController();
        }
        if("/student/view.do".equals(servletPath) && "GET".equalsIgnoreCase(method)){
            command = new StudentViewController();
        }

        //todo resolveCommand 수정 http-method를 고려

        return command;
    }

}
/*@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX="redirect";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        try{
            //실제 요청 처리할 servlet을 결정
            String servletPath = resolveServlet(req.getServletPath());
            RequestDispatcher rd = req.getRequestDispatcher(servletPath);
            rd.include(req, resp);

            //실제 요청을 처리한 servlet이 'view'라는 request 속성값으로 view를 전달해 줌.
            String view = (String) req.getAttribute("view");
            if (!view.startsWith(REDIRECT_PREFIX)) {
                log.error("redirect-url : {}", view.substring(REDIRECT_PREFIX.length()+1));
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()+1));
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher(view);
                dispatcher.forward(req,resp);

            }
        }catch(Exception ex){
            RequestDispatcher errorDispatcher = req.getRequestDispatcher("/error");
            errorDispatcher.forward(req,resp);
        }
    }

    private String resolveServlet(String servletPath){
        String processingServlet = null;
        if("/student/list.do".equals(servletPath)){
            processingServlet = "/student/list";
        }
        if("/error.do".equals(servletPath)){
            processingServlet = "/error";
        }
        if("/student/delete.do".equals(servletPath)){
            processingServlet = "/student/delete";
        }
        if("/student/register.do".equals(servletPath)){
            processingServlet = "/student/register";
        }
        if("/student/update.do".equals(servletPath)){
            processingServlet = "/student/update";
        }
        if("/student/view.do".equals(servletPath)){
            processingServlet = "/student/view";
        }

        //todo 실행할 servlet 결정하기

        return processingServlet;
    }

}*/
