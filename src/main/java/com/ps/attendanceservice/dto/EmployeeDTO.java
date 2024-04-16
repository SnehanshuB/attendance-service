package com.ps.attendanceservice.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDTO {
    private Integer swipeId;
    private Integer employeeId;
    private Integer swipeCounts;
    private SwipeType swipeType;
    private LocalDateTime swipeTimestamp;
}
