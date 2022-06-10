package com.stc.employee.mapper;

import com.stc.employee.dto.EmployeeDto;
import com.stc.employee.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface EmployeeMapper {

    @Mappings({
            @Mapping(target = "employeeId", source = "dto.employeeId" , ignore = true),
            @Mapping(target = "creationDate", source = "dto.creationDate" , ignore = true),
            @Mapping(target = "updateDate", source = "dto.updateDate" , ignore = true)
    })
    Employee mapToEntity(EmployeeDto dto);

    EmployeeDto mapToDto(Employee entity);

}