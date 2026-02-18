package com.example.University.Portal.Models.AuthenticationModel;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.University.Portal.Database_Connection.LoginInfo;
import com.example.University.Portal.Repository.AuthRepository;

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private AuthRepository authRepository;
    @Override
    public UserDetails loadUserByUsername(String userEmail)  {
        authRepository.findByEmail(userEmail);
        if(authRepository.findByEmail(userEmail).isEmpty()) {
            throw new UsernameNotFoundException("User Not Found");
        }else{
            Optional<LoginInfo> loginInfo = authRepository.findByEmail(userEmail);
            return new UserPrinciple(loginInfo)


        }
        
        return null;
    


    }
    
}
