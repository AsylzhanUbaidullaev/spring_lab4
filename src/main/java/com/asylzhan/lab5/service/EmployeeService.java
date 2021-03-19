package com.asylzhan.lab5.service;

import com.asylzhan.lab5.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllSalariedEmployee();
    List<Employee> getAllHourlyEmployee();
    List<Employee> getAllCommissionEmployee();
    List<Employee> getAllSalariedCommission();
    void updateEmployeeFixedSalary(Employee employee);
}
