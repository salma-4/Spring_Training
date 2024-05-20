package com.app.security.jwtdemo.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    UserDetailsService userDetailsService(){
        // manage user details ==> local memo

        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        UserDetails user = User
                .withUsername("salma")
                .password(passwordEncoder().encode("1234"))
                .authorities("read")
                .build();
        userDetailsManager.createUser(user);
        return userDetailsManager;
    }
    @Bean
    BCryptPasswordEncoder passwordEncoder (){
        return new  BCryptPasswordEncoder();
    }
    @Bean
    SecurityFilterChain  filterChain (HttpSecurity http ) throws  Exception{
        http.httpBasic();
        //any request to the application is authenticated.
        http.authorizeHttpRequests().anyRequest().authenticated();
        return http.build();
    }
}
