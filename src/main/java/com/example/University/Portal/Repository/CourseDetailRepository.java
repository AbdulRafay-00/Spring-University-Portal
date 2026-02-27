package com.example.University.Portal.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.University.Portal.Database_Connection.CourseInfo.CourseTable;

public interface CourseDetailRepository extends JpaRepository<CourseTable, Long> {
    Optional<CourseTable> findByCourseId(String courseId);
    
}
