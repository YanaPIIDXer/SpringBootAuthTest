package com.yanap.authtest.security;

import com.yanap.authtest.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(1)
@EnableWebSecurity
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/login/admin/**")
            .formLogin()
            .loginPage("/login/admin/auth").permitAll()
            .loginProcessingUrl("/login/admin/process")
            .failureUrl("/")
            .defaultSuccessUrl("/admin")
            .usernameParameter("name")
            .passwordParameter("password");

        http.antMatcher("/admin")
            .authorizeRequests()
            .antMatchers("/admin").hasRole("ADMIN")
            .anyRequest().authenticated();
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }
}
