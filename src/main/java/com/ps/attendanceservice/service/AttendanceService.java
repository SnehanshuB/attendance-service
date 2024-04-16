package com.ps.attendanceservice.service;

import com.ps.attendanceservice.dto.EmployeeDTO;
import com.ps.attendanceservice.exception.AttendanceException;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceService {
    String submitSwipe(EmployeeDTO employee) throws AttendanceException;
    String attendanceStatus(Integer employeeId, LocalDate date) throws AttendanceException;
    List<EmployeeDTO> getEmployees() throws AttendanceException;
}
