package com.stc.leaves.rest;

import com.stc.leaves.dto.EmployeeLeaveRequest;
import com.stc.leaves.dto.EmployeeLeavesCountDto;
import com.stc.leaves.dto.EmployeeLeavesDto;
import com.stc.leaves.service.EmployeeLeavesService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Employee Leaves", tags = "Employee Leaves", description = "Employee Leaves Endpoints")
@RestController
public class EmployeeLeavesRestController {

    @Autowired
    private EmployeeLeavesService employeeLeavesService;

    @PostMapping(path = "/submit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeLeavesDto> submitLeave(@RequestBody EmployeeLeaveRequest leaveRequest){
        return new ResponseEntity<>(employeeLeavesService.submitEmployeeLeave(leaveRequest), HttpStatus.OK);
    }

    @GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeLeavesCountDto>> listLeaves(){
        return new ResponseEntity<>(employeeLeavesService.listEmployeesLeaves(), HttpStatus.OK);
    }

}