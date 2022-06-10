package com.stc.employee.service;

import com.stc.employee.dto.EmployeeDto;
import com.stc.employee.entity.Employee;
import com.stc.employee.mapper.EmployeeMapper;
import com.stc.employee.repository.EmployeeRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class EmployeeService {

    private EmployeeMapper mapper = Mappers.getMapper(EmployeeMapper.class);

    private static AtomicReference<Long> currentTime = new AtomicReference<>(System.currentTimeMillis());

    @Autowired
    private EmployeeRepository repository;

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = mapper.mapToEntity(employeeDto);
        long globalEmployeeId = currentTime.accumulateAndGet(System.currentTimeMillis(), (prev, next) ->
                next > prev ? next : prev + 1);
        employee.setEmployeeId(String.valueOf(globalEmployeeId));
        employee.setCreationDate(new Date());
        repository.saveEmployee(employee);

        return mapper.mapToDto(employee);
    }

    public EmployeeDto updateEmployee(EmployeeDto employeeDto){
        Employee employee = repository.getEmployee(employeeDto.getEmployeeId());
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhone(employeeDto.getPhone());
        repository.saveEmployee(employee);
        return mapper.mapToDto(employee);
    }

    public EmployeeDto getEmployee(String employeeId){
        Employee employee = repository.getEmployee(employeeId);
        return mapper.mapToDto(employee);
    }
}