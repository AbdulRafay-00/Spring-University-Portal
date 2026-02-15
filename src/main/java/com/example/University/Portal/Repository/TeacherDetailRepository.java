package com.example.University.Portal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.University.Portal.Database_Connection.TeacherInfo;

@Repository
public interface TeacherDetailRepository extends JpaRepository<TeacherInfo, Long> {

    
}