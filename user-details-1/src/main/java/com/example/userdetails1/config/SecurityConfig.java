package com.example.userdetails1.config;

import com.example.userdetails1.ds.DummyUser;
import com.example.userdetails1.service.InMemoryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        DummyUser u1 = new DummyUser("pyae","123123","read");
        DummyUser u2 = new DummyUser("sone","123123","read");
        DummyUser u3 = new DummyUser("aung","123123","read");

        List<DummyUser> users = List.of(u1,u2,u3);
        return new InMemoryUserDetailsService(users);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
