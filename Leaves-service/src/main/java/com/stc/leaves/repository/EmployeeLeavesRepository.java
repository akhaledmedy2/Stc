package com.stc.leaves.repository;

import com.stc.leaves.dao.EmployeeLeavesDao;
import com.stc.leaves.entity.EmployeeLeaves;
import com.stc.leaves.entity.LeavesCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class EmployeeLeavesRepository {

    @Autowired
    private EmployeeLeavesDao dao;

    public void saveEmployeeLeave(EmployeeLeaves employeeLeaves){
        employeeLeaves.setUpdateDate(new Date());
        dao.save(employeeLeaves);
    }

    public List<LeavesCount> getAllLeavesGroupedByEmployee(){
        return dao.findAllCountAndGroupByEmployee();
    }
}