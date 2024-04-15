package com.ps.attendanceservice.service;

import com.ps.attendanceservice.dao.AttendanceServiceDAO;
import com.ps.attendanceservice.dto.EmployeeDTO;
import com.ps.attendanceservice.entity.Employee;
import com.ps.attendanceservice.exception.AttendanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class AttendanceServiceImplementation implements AttendanceService {
    @Autowired
    private AttendanceServiceDAO attendanceServiceDAO;

    public String submitSwipe(EmployeeDTO employee) throws AttendanceException {
        try {
            Employee employee1 = new Employee();
            employee1.setEmployeeId(employee.getEmployeeId());
            employee1.setSwipeType(employee.getSwipeType());
            employee1.setSwipeTimestamp(LocalDateTime.now());
            employee1.setSwipeCounts(attendanceServiceDAO.getSwipeCountsByEmployeeId(employee.getEmployeeId()));
            return "User record successfully submitted";
        }catch (Exception e){
            throw new AttendanceException(e.getMessage(), e);
        }
    }

    @Override
    public String attendanceStatus(Long employeeId, LocalDate date) throws AttendanceException {
        return "";
    }
}
