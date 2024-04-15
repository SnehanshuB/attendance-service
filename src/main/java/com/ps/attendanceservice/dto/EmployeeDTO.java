package com.ps.attendanceservice.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDTO {
    private Long employeeId;
    private Long swipeCounts;
    private SwipeType swipeType;
    private Long swipeTimestamp;
}
