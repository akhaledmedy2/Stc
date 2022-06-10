package com.stc.employee.dao;

import com.stc.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Long> {

    Employee findOneByEmployeeId(String employeeId);
}