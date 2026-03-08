package com.example.University.Portal.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.University.Portal.Database_Connection.AcademicCalender.AcademicTimeTable;
import com.example.University.Portal.Database_Connection.AcademicCalender.AcademicYearStatusenum;

@Repository
public interface AcademicTimeTableRepository extends JpaRepository<AcademicTimeTable, Long> {
    List<AcademicTimeTable> findByEndDateBeforeAndStatus(LocalDate date, AcademicYearStatusenum status);
}
