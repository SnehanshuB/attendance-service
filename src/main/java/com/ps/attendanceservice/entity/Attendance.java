package com.ps.attendanceservice.entity;

import com.ps.attendanceservice.dto.AttendanceStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "attendance_date")
    private LocalDate attendanceDate;

    @Column(name = "logged_hours")
    private LocalTime loggedHours;

    @Column(name = "attendance_status")
    private AttendanceStatus attendanceStatus;
}
