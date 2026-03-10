package com.example.University.Portal.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.University.Portal.Database_Connection.AcademicCalender.AcademicTimeTable;
import com.example.University.Portal.Database_Connection.AcademicCalender.AcademicYearStatusenum;
import com.example.University.Portal.Database_Connection.CourseInfo.CourseTable;

@Repository
public interface AcademicTimeTableRepository extends JpaRepository<AcademicTimeTable, Long> {
    // List<AcademicTimeTable> findByEndDateBeforeAndStatus(LocalDate date, AcademicYearStatusenum status);

    @Query("SELECT s FROM AcademicTimeTable s " +
       "WHERE s.endDate <= :date AND s.status = :status")
List<AcademicTimeTable> findByEndDateBeforeOrEqualAndStatus(@Param("date") LocalDate date,@Param("status") AcademicYearStatusenum status);

    Optional<AcademicTimeTable> findBySessionId(String academicSessionId);
}
