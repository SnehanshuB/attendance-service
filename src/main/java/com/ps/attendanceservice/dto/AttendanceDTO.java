package com.ps.attendanceservice.dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AttendanceDTO {
    private Integer employeeId;
    private LocalDate attendanceDate;
    private LocalTime loggedHours;
    private AttendanceStatus attendanceStatus;
}
