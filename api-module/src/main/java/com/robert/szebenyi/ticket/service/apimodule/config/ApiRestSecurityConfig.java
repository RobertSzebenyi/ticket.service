package com.robert.szebenyi.ticket.service.apimodule.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@RequiredArgsConstructor
public class ApiRestSecurityConfig extends WebSecurityConfigurerAdapter {

    //private final SecurityExceptionHandler securityExceptionHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .antMatcher("/api/**")
                .authorizeRequests()
                .anyRequest()
                .permitAll()  // TODO
//                .authenticated()
//                .and()
//                .httpBasic()
//                // .authenticationEntryPoint(authenticationEntryPoint())
//                .and()
//                .exceptionHandling()
        // .accessDeniedHandler(accessDeniedHandler())
        ;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
