package com.stc.leaves.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeLeavesDto {
    private long employeeId;
    private String employeeName;
    private String leaveType;
    private Date leaveTime;
    private Date creationDate;
    private Date updateDate;
}