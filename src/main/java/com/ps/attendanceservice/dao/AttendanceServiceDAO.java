package com.ps.attendanceservice.dao;

import com.ps.attendanceservice.service.AttendanceService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AttendanceServiceDAO extends JpaRepository<AttendanceService, Integer> {
    @Query(value = "select swipeCounts from users U where employee_id=:employeeDd", nativeQuery = true)
    Long getSwipeCountsByEmployeeId(Long employeeId);
}
