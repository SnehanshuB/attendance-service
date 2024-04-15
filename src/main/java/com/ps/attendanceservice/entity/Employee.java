package com.ps.attendanceservice.entity;

import com.ps.attendanceservice.dto.SwipeType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class Employee {

    @Id
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "swipe_counts")
    private Long swipeCounts;

    @Column(name = "swipe_type")
    private SwipeType swipeType;

    @Column(name = "swipe_timestamp")
    private LocalDateTime swipeTimestamp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) && Objects.equals(swipeCounts, employee.swipeCounts) && swipeType == employee.swipeType && Objects.equals(swipeTimestamp, employee.swipeTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, swipeCounts, swipeType, swipeTimestamp);
    }
}
