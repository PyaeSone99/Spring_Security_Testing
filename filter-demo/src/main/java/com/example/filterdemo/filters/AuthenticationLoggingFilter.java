package com.example.filterdemo.filters;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class AuthenticationLoggingFilter extends OncePerRequestFilter{    //    implements Filter

    private final Logger logger = LoggerFactory.getLogger(AuthenticationLoggingFilter.class.getName());

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var key = request.getHeader("x-api-key");
        logger.info("Successfully Authenticated request with id "+ key);
        filterChain.doFilter(request,response);
    }

//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        var httpRequest = (HttpServletRequest)servletRequest;
//        var key = httpRequest.getHeader("x-api-key");
//        logger.info("Successfully Authenticated request with id "+ key);
//        filterChain.doFilter(servletRequest,servletResponse);
//    }
}
