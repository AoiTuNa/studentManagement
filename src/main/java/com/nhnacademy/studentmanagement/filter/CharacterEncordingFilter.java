package com.nhnacademy.studentmanagement.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncordingFilter implements Filter {
    private  String encoding;

    @Override
    public void init(FilterConfig config) throws ServletException{
        this.encoding = config.getInitParameter("encoding");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(this.encoding);
        chain.doFilter(request,response);
    }
}
