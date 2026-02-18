package com.example.University.Portal.Models.AuthenticationModel;

import java.util.Collection;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.University.Portal.Database_Connection.LoginInfo;

public class UserPrinciple implements UserDetails{

    private LoginInfo loginInfo;
    public UserPrinciple( LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "ROLE_" + loginInfo.getRole());
    }

    @Override
    public @Nullable String getPassword() {
        return loginInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return loginInfo.getEmail();
    }
    
}
