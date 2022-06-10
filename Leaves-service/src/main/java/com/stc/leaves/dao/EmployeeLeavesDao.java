package com.stc.leaves.dao;

import com.stc.leaves.entity.EmployeeLeaves;
import com.stc.leaves.entity.LeavesCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeLeavesDao extends JpaRepository<EmployeeLeaves,Long> {

    @Query(value = "select new com.stc.leaves.entity.LeavesCount(el.employee , count(*))" +
            " from EmployeeLeaves el group by el.employee")
    List<LeavesCount> findAllCountAndGroupByEmployee();
}