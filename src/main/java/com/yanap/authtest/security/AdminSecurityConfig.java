package com.yanap.authtest.security;

import com.yanap.authtest.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Order(1)
@EnableWebSecurity
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/", "/login/**").permitAll()
            .antMatchers().hasRole("ADMIN")
            .anyRequest().authenticated();

        http.formLogin()
            .loginPage("/login/admin")
            .loginProcessingUrl("/login/admin/auth")
            .failureUrl("/")
            .defaultSuccessUrl("/admin")
            .usernameParameter("name")
            .passwordParameter("password");

        http.logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/");
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }
}
