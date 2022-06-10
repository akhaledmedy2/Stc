package com.stc.leaves.dao;

import com.stc.leaves.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Long> {

    Employee findOneByEmployeeId(String employeeId);
}