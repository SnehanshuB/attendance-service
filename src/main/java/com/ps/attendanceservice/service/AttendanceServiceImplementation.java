package com.ps.attendanceservice.service;

import com.ps.attendanceservice.dao.AttendanceServiceDAO;
import com.ps.attendanceservice.dto.EmployeeDTO;
import com.ps.attendanceservice.dto.SwipeType;
import com.ps.attendanceservice.entity.Employee;
import com.ps.attendanceservice.exception.AttendanceException;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class AttendanceServiceImplementation implements AttendanceService {

    private static final Logger logger = LogManager.getLogger(AttendanceServiceImplementation.class);

    @Autowired
    private AttendanceServiceDAO attendanceServiceDAO;

    public boolean isEmployeeIdPresent(Integer employeeId) {
        Integer count = attendanceServiceDAO.getCountByEmployeeId(employeeId);
        return count > 0;
    }

    public String submitSwipe(EmployeeDTO employee) throws AttendanceException {
        try {
            // Validate input data
            validateEmployeeDTO(employee);

            // Create and populate Employee entity
            Employee newEmployee = new Employee();
            newEmployee.setEmployeeId(employee.getEmployeeId());
            newEmployee.setSwipeType(employee.getSwipeType());
            if (isEmployeeIdPresent(employee.getEmployeeId())) {
                newEmployee.setSwipeCounts(attendanceServiceDAO.getSwipeCountsByEmployeeId(employee.getEmployeeId())+1);
            }else {
                newEmployee.setSwipeCounts(1);
            }
            newEmployee.setSwipeTimestamp(LocalDateTime.now());
            // Save the entity within a transaction
            attendanceServiceDAO.saveAndFlush(newEmployee);

            // Log success message
            logger.info("User record successfully submitted");

            return "User record successfully submitted";
        } catch (DataIntegrityViolationException e) {
            // Handle database integrity violation (e.g., unique constraint violation)
            logger.error("Data integrity violation: " + e.getMessage(), e);
            throw new AttendanceException("Data integrity violation: " + e.getMessage(), e);
        } catch (Exception e) {
            // Handle other exceptions
            logger.error("Error submitting swipe: " + e.getMessage(), e);
            throw new AttendanceException("Error submitting swipe: " + e.getMessage(), e);
        }
    }

    private void validateEmployeeDTO(EmployeeDTO employee) throws AttendanceException {
        // Implement validation logic here
        if (employee == null) {
            throw new AttendanceException("EmployeeDTO cannot be null");
        }
        // Validate other fields as needed
    }


    @Override
    public String attendanceStatus(Integer employeeId, LocalDate date) throws AttendanceException {
        return "";
    }

    @Override
    public List<EmployeeDTO> getEmployees() throws AttendanceException {
        List<Employee> employees = attendanceServiceDAO.findAll();
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setSwipeId(employee.getSwipeId());
            employeeDTO.setEmployeeId(employee.getEmployeeId());
            employeeDTO.setSwipeType(employee.getSwipeType());
            employeeDTO.setSwipeTimestamp(employee.getSwipeTimestamp());
            employeeDTO.setSwipeCounts(employee.getSwipeCounts());
            employeeDTOs.add(employeeDTO);
        }
        return employeeDTOs;
    }
}
