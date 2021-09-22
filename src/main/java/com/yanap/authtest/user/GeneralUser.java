package com.yanap.authtest.user;

public class GeneralUser extends User {
    @Override
    public String getPassword() {
        return "{noop}general";
    }

    @Override
    public String getUsername() {
        return "general";
    }
    
}
