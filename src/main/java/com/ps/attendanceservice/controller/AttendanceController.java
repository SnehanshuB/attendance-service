package com.ps.attendanceservice.controller;

import com.ps.attendanceservice.dto.EmployeeDTO;
import com.ps.attendanceservice.entity.Employee;
import com.ps.attendanceservice.exception.AttendanceException;
import com.ps.attendanceservice.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/requests")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/submitSwipe")
    public ResponseEntity<String> submitSwipe(@RequestBody EmployeeDTO employee) {
        try {
            return new ResponseEntity<>(attendanceService.submitSwipe(employee),HttpStatus.OK);
        }catch (AttendanceException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,e.getMessage());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    @GetMapping("/getAllSwipes")
    public ResponseEntity<List<EmployeeDTO>> getAllSwipes(){
        try {
            return new ResponseEntity<>(attendanceService.getEmployees(), HttpStatus.OK);
        }catch (AttendanceException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT,e.getMessage());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }

    }

    @GetMapping("/getAttendanceById/{id}/{date}")
    public ResponseEntity<String> getAttendanceStatusByEmployeeIdAndDate(@RequestParam("id") Integer employeeId, @RequestParam("date") LocalDate date) {
        try {
            return new ResponseEntity<>(attendanceService.attendanceStatus(employeeId, date), HttpStatus.OK);
        }catch (AttendanceException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT,e.getMessage());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }
}
