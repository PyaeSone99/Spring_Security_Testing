package com.example.csrfdemo.logger;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class CsrfTokenLogger implements Filter {

    private Logger logger = LoggerFactory.getLogger(CsrfTokenLogger.class.getName());
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Object object = servletRequest.getAttribute("_csrf");
        CsrfToken token = (CsrfToken) object;
        logger.info("CSRF token"+ token.getToken());
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
