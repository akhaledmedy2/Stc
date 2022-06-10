package com.stc.leaves.dto;

import lombok.Data;

@Data
public class EmployeeLeavesCountDto {
    private long employeeId;
    private String employeeName;
    private long currentSubmittedLeaves;
}