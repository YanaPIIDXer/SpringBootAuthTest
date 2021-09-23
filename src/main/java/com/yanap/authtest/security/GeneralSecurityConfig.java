package com.yanap.authtest.security;

import com.yanap.authtest.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Order(2)
@EnableWebSecurity
public class GeneralSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/general/**")
                .authorizeRequests()
                    .antMatchers("/general/**").hasRole("GENERAL")
                    .anyRequest().authenticated()
        .and()
            .formLogin()
                .loginPage("/login/general/auth")
                .loginProcessingUrl("/login/process")
                .defaultSuccessUrl("/general")
                .failureUrl("/")
                .usernameParameter("name")
                .passwordParameter("password")
        .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
        .and()
            .csrf().disable();
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }    
}
