package com.example.filterdemo.config;

import com.example.filterdemo.filters.AuthenticationLoggingFilter;
import com.example.filterdemo.filters.CustomValidationFilter;
import com.example.filterdemo.filters.StaticKeyAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {
    @Autowired
    private StaticKeyAuthenticationFilter staticKeyAuthenticationFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{

        http.httpBasic().and()
                .addFilterBefore(new CustomValidationFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new AuthenticationLoggingFilter(),BasicAuthenticationFilter.class)
//                .addFilterAt(staticKeyAuthenticationFilter,BasicAuthenticationFilter.class)
//                .addFilterAfter(new AuthenticationLoggingFilter(),StaticKeyAuthenticationFilter.class)
                .authorizeHttpRequests()
                .anyRequest()
                .permitAll();
        return http.build();
    }
}
