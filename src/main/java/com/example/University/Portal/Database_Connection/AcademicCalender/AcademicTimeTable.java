package com.example.University.Portal.Database_Connection.AcademicCalender;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class AcademicTimeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private int year;

    @NonNull
    private String semester; // "SPRING" or "FALL"

    @NonNull
    private LocalDate startDate;
    @NonNull
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private AcademicYearStatusenum status;

    @NonNull
    private String sessionId;
}
    

