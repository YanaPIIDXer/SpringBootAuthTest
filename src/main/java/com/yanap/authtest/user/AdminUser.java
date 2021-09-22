package com.yanap.authtest.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class AdminUser extends User {
    @Override
    public String getPassword() {
        return "{noop}admin";
    }

    @Override
    public String getUsername() {
        return "admin";
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return list;
    }
}
