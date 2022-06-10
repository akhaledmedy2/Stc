package com.stc.employee.repository;

import com.stc.employee.dao.EmployeeDao;
import com.stc.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public class EmployeeRepository {

    @Autowired
    private EmployeeDao dao;

    @Transactional
    public void saveEmployee(Employee e) {
        e.setUpdateDate(new Date());
        dao.save(e);
    }

    @Transactional
    public Employee getEmployee(String employeeId) {
        return dao.findOneByEmployeeId(employeeId);
    }

}