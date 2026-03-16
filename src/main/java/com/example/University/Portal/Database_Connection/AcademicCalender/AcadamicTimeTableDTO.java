package com.example.University.Portal.Database_Connection.AcademicCalender;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcadamicTimeTableDTO {
    
    private int year;

    private String session; // "SPRING" or "FALL"

    private LocalDate startDate;

    private LocalDate endDate;
}
