package com.ps.attendanceservice.exception;

public class AttendanceException extends Exception{
    public AttendanceException() { super("Attendance Service Exception"); }
    public AttendanceException(String message) { super(message); }
    public AttendanceException(String message, Throwable cause) { super(message, cause); }
}
