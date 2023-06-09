package com.example.customspringsecurity.filter;

import com.example.customspringsecurity.manager.CustomAuthenticationManager;
import com.example.customspringsecurity.authentication.ApiKeyAuthentication;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.security.sasl.AuthenticationException;
import java.io.IOException;


public class ApiKeyFilter extends OncePerRequestFilter {
    private final String key;

    public ApiKeyFilter(String key) {
        this.key = key;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        CustomAuthenticationManager  authenticationManager = new CustomAuthenticationManager(key);
        var requestKey = request.getHeader("api-key-secret");
        if (requestKey == null || "null".equals(requestKey)){
            filterChain.doFilter(request,response);
        }
        var a = new ApiKeyAuthentication(requestKey);
        try{
            var auth = authenticationManager.authenticate(a);
            if (auth.isAuthenticated()){
                SecurityContextHolder.getContext().setAuthentication(auth);
                filterChain.doFilter(request,response);
            }else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }catch (AuthenticationException e){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

    }
}
