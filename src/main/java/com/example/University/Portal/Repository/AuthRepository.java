package com.example.University.Portal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.University.Portal.Database_Connection.LoginInfo;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<LoginInfo, Long> {
    Optional<LoginInfo> findByEmail(String email);
    
}
