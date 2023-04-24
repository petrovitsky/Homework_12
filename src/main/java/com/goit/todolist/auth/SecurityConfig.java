package com.goit.todolist.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final CustomAuthenticationProvider customAuthenticationProvider;



    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                    .authorizeRequests()
                    .antMatchers("admin/**").hasRole("admin")
                    .anyRequest()
                    .authenticated()
                .and()
                    .httpBasic()
                .and()
                    .csrf().disable()
                    .formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Autowired
    public void injectCustomAuthenticationProvider (AuthenticationManagerBuilder auth){
        auth.authenticationProvider(customAuthenticationProvider);
    }
}