package com.example.University.Portal.Models.AuthenticationModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.University.Portal.Database_Connection.LoginInfo;
import com.example.University.Portal.Repository.AuthRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private AuthRepository authRepository;
    @Override
    public UserDetails loadUserByUsername(String userEmail)  {
        LoginInfo loginInfo = authRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + userEmail));

        return new UserPrinciple(loginInfo);
    }
    
}
