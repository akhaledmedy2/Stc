package com.stc.leaves.mapper;

import com.stc.leaves.dto.EmployeeLeavesCountDto;
import com.stc.leaves.dto.EmployeeLeavesDto;
import com.stc.leaves.entity.Employee;
import com.stc.leaves.entity.EmployeeLeaves;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface EmployeeLeaveMapper {

    @Mappings({
            @Mapping(target = "leaveType", source = "entity.leaveType"),
            @Mapping(target = "leaveTime", source = "entity.leaveDate"),
            @Mapping(target = "updateDate", source = "entity.updateDate"),
            @Mapping(target = "employeeId", source = "entity.employee.employeeId"),
            @Mapping(target = "employeeName", source = "entity.employee.name")
    })
    EmployeeLeavesDto mapToDto(EmployeeLeaves entity);

    @Mappings({
            @Mapping(target = "employeeId", source = "entity.employeeId"),
            @Mapping(target = "employeeName", source = "entity.name"),
            @Mapping(target = "currentSubmittedLeaves", source = "leavesCount")
    })
    EmployeeLeavesCountDto mapToEmployeeDto(Employee entity, long leavesCount);
}