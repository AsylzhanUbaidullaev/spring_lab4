package com.asylzhan.lab5.controller;

import com.asylzhan.lab5.entity.Employee;
import com.asylzhan.lab5.event.SalaryChangeEvent;
import com.asylzhan.lab5.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {
    private ApplicationEventPublisher eventPublisher;
    @Autowired
    private EmployeeService employeeService;

    public List<Employee> getAllSalariedEmployee() {
        return employeeService.getAllSalariedEmployee();
    }

    public List<Employee> getAllHourlyEmployee() {
        return employeeService.getAllHourlyEmployee();
    }

    public List<Employee> getAllCommissionEmployee() {
        return employeeService.getAllCommissionEmployee();
    }

    public List<Employee> getAllSalariedCommission() {
        return employeeService.getAllSalariedCommission();
    }

    public void updateEmployeeFixedSalary(Employee employee, Double oldSalary) {
        this.employeeService.updateEmployeeFixedSalary(employee);
        this.eventPublisher.publishEvent(new SalaryChangeEvent(this, employee, oldSalary));
    }
}
