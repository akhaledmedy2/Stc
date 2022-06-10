package com.stc.leaves.repository;

import com.stc.leaves.dao.EmployeeDao;
import com.stc.leaves.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    @Autowired
    private EmployeeDao dao;

    public Employee getEmployeeByEmployeeId(String employeeId){
        return dao.findOneByEmployeeId(employeeId);
    }
}