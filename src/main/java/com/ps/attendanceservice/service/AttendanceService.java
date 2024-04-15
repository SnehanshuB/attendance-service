package com.ps.attendanceservice.service;

import com.ps.attendanceservice.dto.EmployeeDTO;
import com.ps.attendanceservice.entity.Employee;
import com.ps.attendanceservice.exception.AttendanceException;

import java.time.LocalDate;
import java.time.LocalTime;

public interface AttendanceService {
    String submitSwipe(EmployeeDTO employee) throws AttendanceException;
    String attendanceStatus(Long employeeId, LocalDate date) throws AttendanceException;
}
