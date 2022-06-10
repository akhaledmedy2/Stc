package com.stc.employee.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDto {
    private String employeeId;
    private String name;
    private String phone;
    private String email;
    private Date creationDate;
    private Date updateDate;
}