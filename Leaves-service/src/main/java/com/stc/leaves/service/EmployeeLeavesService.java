package com.stc.leaves.service;

import com.stc.leaves.dto.EmployeeLeaveRequest;
import com.stc.leaves.dto.EmployeeLeavesCountDto;
import com.stc.leaves.dto.EmployeeLeavesDto;
import com.stc.leaves.entity.Employee;
import com.stc.leaves.entity.EmployeeLeaves;
import com.stc.leaves.entity.LeavesCount;
import com.stc.leaves.enums.LeaveTypes;
import com.stc.leaves.mapper.EmployeeLeaveMapper;
import com.stc.leaves.repository.EmployeeLeavesRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeLeavesService {

    private EmployeeLeaveMapper mapper = Mappers.getMapper(EmployeeLeaveMapper.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeLeavesRepository repository;

    public EmployeeLeavesDto submitEmployeeLeave(EmployeeLeaveRequest leaveRequest) {
        String leaveType;
        try {
            leaveType = LeaveTypes.values()[leaveRequest.getLeaveType()].name();
        } catch (Exception ex) {
            throw new EntityNotFoundException("leave type is not defined 0:paid/1:unpaid");
        }
        Employee employee = employeeService.getEmployeeById(leaveRequest.getEmployeeId());
        if (employee == null) {
            throw new EntityNotFoundException("employee not found against this id");
        }
        EmployeeLeaves employeeLeaves = new EmployeeLeaves();
        employeeLeaves.setEmployee(employee);
        employeeLeaves.setCreationDate(new Date());
        employeeLeaves.setLeaveType(leaveType);
        employeeLeaves.setLeaveDate(leaveRequest.getLeaveTime());
        repository.saveEmployeeLeave(employeeLeaves);
        return mapper.mapToDto(employeeLeaves);
    }

    public List<EmployeeLeavesCountDto> listEmployeesLeaves() {
        List<LeavesCount> employeeLeaves = repository.getAllLeavesGroupedByEmployee();
        List<EmployeeLeavesCountDto> employeeLeavesList = new ArrayList<>();
        for (LeavesCount leave : employeeLeaves) {
            employeeLeavesList.add(mapper.mapToEmployeeDto(leave.getEmployee(),leave.getLeavesCount()));
        }
        return employeeLeavesList;
    }
}