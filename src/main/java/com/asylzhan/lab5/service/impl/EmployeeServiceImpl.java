package com.asylzhan.lab5.service.impl;

import com.asylzhan.lab5.entity.Employee;
import com.asylzhan.lab5.entity.EmployeeType;
import com.asylzhan.lab5.repo.EmployeeRepo;
import com.asylzhan.lab5.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllSalariedEmployee() {
        return employeeRepo.getEmployeesByEmplType(EmployeeType.SALARIED);
    }

    @Override
    public List<Employee> getAllHourlyEmployee() {
        return employeeRepo.getEmployeesByEmplType(EmployeeType.HOURLY);
    }

    @Override
    public List<Employee> getAllCommissionEmployee() {
        return employeeRepo.getEmployeesByEmplType(EmployeeType.COMMISION);
    }

    @Override
    public List<Employee> getAllSalariedCommission() {
        return employeeRepo.getEmployeesByEmplType(EmployeeType.SALARIED_COMMISION);
    }

    @Override
    public void updateEmployeeFixedSalary(Employee employee) {
        employeeRepo.save(employee);
    }
}
