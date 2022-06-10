package com.stc.leaves.service;

import com.stc.leaves.entity.Employee;
import com.stc.leaves.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee getEmployeeById(String employeeId){
        return repository.getEmployeeByEmployeeId(employeeId);
    }
}