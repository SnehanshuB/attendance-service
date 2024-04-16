package com.ps.attendanceservice.dao;

import com.ps.attendanceservice.entity.Employee;
import com.ps.attendanceservice.service.AttendanceService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AttendanceServiceDAO extends JpaRepository<Employee, Integer> {

    @Query(value = "select max(swipe_counts) from users U where employee_id=:employeeId", nativeQuery = true)
    Integer getSwipeCountsByEmployeeId(@Param("employeeId") Integer employeeId);

    @Query(value = "SELECT COUNT(*) FROM users U WHERE U.employee_id = :employeeId", nativeQuery = true)
    Integer getCountByEmployeeId(@Param("employeeId") Integer employeeId);

}
