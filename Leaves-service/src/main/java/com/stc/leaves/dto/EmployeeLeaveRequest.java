package com.stc.leaves.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeLeaveRequest {
    private String employeeId;
    private int leaveType;
    private Date leaveTime;
}