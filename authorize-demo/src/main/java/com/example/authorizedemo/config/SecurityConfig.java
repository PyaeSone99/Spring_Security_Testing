package com.example.authorizedemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        String expression = "hasAuthority('read') and !hasAuthority('delete') and !hasAuthority('write')";
        String timeExpression = "T(java.time.LocalTime).now().isBefore(T(java.time.LocalTime).of(12,0))";
        http.httpBasic().and()
                //.authorizeHttpRequests( c -> c.anyRequest()
                        //.access(new WebExpressionAuthorizationManager(timeExpression)));
                        //.hasRole("USER"));
                        //.hasAnyRole("USER","ADMIN"));
                .authorizeHttpRequests()
                        .requestMatchers("/hello").hasRole("USER")
                .requestMatchers("/greeting").hasRole("ADMIN")
                .requestMatchers("/products/*/{code:^[0-9]*$}")
                //
                .permitAll().anyRequest()
                      .authenticated();
        http.csrf().disable();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        var uds = new InMemoryUserDetailsManager();
        var user1 = User.withUsername("pyae")
                .password(passwordEncoder().encode("123"))
                .authorities("ROLE_USER","ROLE_ADMIN").build();
        var user2 = User.withUsername("sone").password(passwordEncoder()
                .encode("456"))
                //.authorities("ROLE_USER").build();
                        .roles("USER").build();
        uds.createUser(user1);
        uds.createUser(user2);
        return uds;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
