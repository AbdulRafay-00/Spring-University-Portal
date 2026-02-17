package com.example.University.Portal.services.StartUpServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

import com.example.University.Portal.Database_Connection.LoginInfo;
import com.example.University.Portal.ExtraServices.RoleClass;
import com.example.University.Portal.Repository.AuthRepository;

public class AdminSeed implements CommandLineRunner{

    @Value("${admin.email}")
    private String adminEmail;

    @Value("${admin.password}")
    private String adminPassword;

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private LoginInfo loginInfo;

    @Override
    public void run(String... args) throws Exception {
        if (authRepository.findByEmail(adminEmail).isPresent()) {
            System.out.println("Admin already exists. Skipping seeding.");
        }else{
            loginInfo.setEmail(adminEmail);
            loginInfo.setPassword(adminPassword);
            loginInfo.setRole(RoleClass.ADMIN);
            authRepository.save(loginInfo);
            System.out.println("Admin user created successfully.");
        }
    }
    
}
