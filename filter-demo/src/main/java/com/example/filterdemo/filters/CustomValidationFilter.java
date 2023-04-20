package com.example.filterdemo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class CustomValidationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var httpRequest = (HttpServletRequest)servletRequest;
        var httpResponse = (HttpServletResponse)servletResponse;
        String key = httpRequest.getHeader("x-api-key");
        if (key == null || key.isBlank()){
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        System.out.println("from custom validation filter"+key);
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
