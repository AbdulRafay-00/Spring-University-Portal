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

//     @Modifying
// @Transactional
// @Query("UPDATE student_info s " +
//     "SET s.current_emester = s.current_semester + 1, " +
//     "    s.current_year = CASE WHEN FUNCTION('MOD', s.current_semester, 2) = 0 THEN s.current_year + 1 ELSE s.current_year END " +
//     "WHERE s.current_semester < 8")


@Modifying
@Transactional
@Query(value = "UPDATE student_info s " +
               "SET s.current_year = CASE WHEN MOD(s.current_semester + 1, 2) = 0 THEN s.current_year ELSE s.current_year + 1 END, " +
               "    s.current_semester = s.current_semester + 1 " +
               "WHERE s.current_semester < 8",
       nativeQuery = true)
int promoteAllStudents();

}
