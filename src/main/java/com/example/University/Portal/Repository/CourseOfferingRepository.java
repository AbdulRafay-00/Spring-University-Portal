package com.example.University.Portal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.University.Portal.Database_Connection.CourseInfo.CourseOfferingTable;

@Repository
public interface CourseOfferingRepository extends JpaRepository<CourseOfferingTable, Long> {
    long CountBySessionDate(int sessionDate);
}
