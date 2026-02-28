// package com.example.University.Portal.Database_Connection;

// import com.example.University.Portal.Database_Connection.CourseInfo.CourseTable;
// import com.example.University.Portal.Database_Connection.Key.TeacherCourseEmbadedId;

// import jakarta.persistence.EmbeddedId;
// import jakarta.persistence.Entity;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.MapsId;
// import jakarta.persistence.Table;
// import lombok.Data;
// import lombok.NoArgsConstructor;
// import lombok.NonNull;
// import lombok.RequiredArgsConstructor;


// @Entity
// @Table(name = "teacher_course_table")
// @Data
// @NoArgsConstructor
// @RequiredArgsConstructor
// public class TeacherCourse {
    
//     @EmbeddedId
//     private TeacherCourseEmbadedId id;

//     @NonNull
//     @ManyToOne
//     @MapsId("courseId")
//     @JoinColumn(name = "course_Id")
//     CourseTable courseTable;

    
//     @NonNull
//     @ManyToOne
//     @MapsId("teacherId")
//     @JoinColumn(name = "teacher_Id")
//     TeacherInfo teacherInfo;
// }
