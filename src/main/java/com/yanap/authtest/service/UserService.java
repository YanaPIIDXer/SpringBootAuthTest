package com.yanap.authtest.service;

import com.yanap.authtest.user.AdminUser;
import com.yanap.authtest.user.GeneralUser;
import com.yanap.authtest.user.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private GeneralUser generalUser = new GeneralUser();
    private AdminUser adminUser = new AdminUser();
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = null;
        if (generalUser.getUsername().equals(name)) { user = generalUser; }
        else if (adminUser.getUsername().equals(name)) { user = adminUser; }
        else { throw new UsernameNotFoundException("UserName Error."); }
        return user;
    }
}
