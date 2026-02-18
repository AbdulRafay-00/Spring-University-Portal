package com.example.University.Portal.services.StartUpServices;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.University.Portal.Database_Connection.AdminInfo;
import com.example.University.Portal.Database_Connection.LoginInfo;
import com.example.University.Portal.ExtraServices.BusinessIdGeneratorService;
import com.example.University.Portal.ExtraServices.RoleClass;
import com.example.University.Portal.Repository.AuthRepository;


@Component
public class AdminSeed implements CommandLineRunner{

    @Value("${admin.email}")
    private String adminEmail;

    @Value("${admin.password}")
    private String adminPassword;

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    BusinessIdGeneratorService idGen;

    
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    
    
    @Override
    public void run(String... args) throws Exception {
        if (authRepository.findByEmail(adminEmail).isPresent()) {
            System.out.println("Admin already exists. Skipping seeding.");
        }else{
            AdminInfo adminInfo = new AdminInfo();
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.setEmail(adminEmail);
            loginInfo.setPassword(passwordEncoder.encode(adminPassword));
            loginInfo.setRole(RoleClass.ADMIN);

            adminInfo.setAdminId(idGen.generateAdminCode());
            adminInfo.setName("Admin User");
            adminInfo.setPhoneNo("1234567890");
            adminInfo.setEmail(adminEmail);
            adminInfo.setJoiningYear(LocalDate.now().getYear()); // Set joining year to current year
            adminInfo.setLoginInfo(loginInfo);
            System.out.println("Admin user created successfully.");
            authRepository.save(loginInfo);
        }
    }
    
}
