package com.yanap.authtest.security;

import com.yanap.authtest.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@Order(2)
@EnableWebSecurity
public class GeneralSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/general/**")
                .authorizeRequests()
                    .antMatchers("/general/login").permitAll()
                    .antMatchers("/general/**").hasRole("GENERAL")
                    .anyRequest().authenticated()
        .and()
            .formLogin()
                .loginPage("/general/login")
                .loginProcessingUrl("/general/process")
                .defaultSuccessUrl("/general")
                .failureUrl("/")
                .usernameParameter("name")
                .passwordParameter("password")
                .permitAll()
        .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/general/logout"))
                .logoutSuccessUrl("/")
                .permitAll()
        .and()
            .csrf().disable();
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }    
}
