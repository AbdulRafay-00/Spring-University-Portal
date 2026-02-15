package com.example.University.Portal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.University.Portal.Database_Connection.StudentInfo;


@Repository
public interface StuDetailRepository extends JpaRepository<StudentInfo, Long> {
    long  CountByJoiningYear(int joiningYear);
}
