package com.yanap.authtest.user;

public class AdminUser extends User {
    @Override
    public String getPassword() {
        return "{noop}admin";
    }

    @Override
    public String getUsername() {
        return "admin";
    }
}
