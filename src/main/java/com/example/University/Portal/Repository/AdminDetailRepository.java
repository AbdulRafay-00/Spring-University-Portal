package com.example.University.Portal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.University.Portal.Database_Connection.AdminInfo;

@Repository
public interface AdminDetailRepository extends JpaRepository <AdminInfo, Long> {
    
    long countByJoiningYear(int joiningYear);
    
}
