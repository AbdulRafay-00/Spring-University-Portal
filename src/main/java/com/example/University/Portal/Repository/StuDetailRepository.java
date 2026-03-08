package com.example.University.Portal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.University.Portal.Database_Connection.StudentInfo;

import jakarta.transaction.Transactional;


@Repository
public interface StuDetailRepository extends JpaRepository<StudentInfo, Long> {
    long countByJoiningYear(int joiningYear);

    @Modifying
@Transactional
@Query("UPDATE StudentInfo s " +
    "SET s.currentSemester = s.currentSemester + 1, " +
    "    s.currentYear = CASE WHEN s.currentSemester % 2 = 0 THEN s.currentYear + 1 ELSE s.currentYear END " +
    "WHERE s.currentSemester < 8")
int promoteAllStudents();

}
