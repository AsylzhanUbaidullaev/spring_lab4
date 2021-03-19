package com.asylzhan.lab5.service;

import com.asylzhan.lab5.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class SalaryCalculatorService {
    public Employee calculateHourlyEmployeeSalary(Employee employee) {
        Double newSalary;

        if (employee.getHoursWorked() > 40) {
            newSalary = 40.0 * employee.getHourRate() + (employee.getHoursWorked() - 40) * 1.5 * employee.getHourRate();
        } else {
            newSalary = employee.getHoursWorked() * employee.getHourRate();
        }
        employee.setFixedSalary(newSalary);

        return employee;
    }

    public Employee calculateSalaryCommissionEmployee(Employee employee, Double amount) {
        Double bonus = amount * employee.getCommRate() / 100;
        employee.setFixedSalary(employee.getFixedSalary() + bonus);

        return employee;
    }

    public Employee calculateSalarySalariedCommissionEmployee(Employee employee, Double amount) {
        Double bonus = amount * employee.getCommRate() / 100;
        employee.setFixedSalary(employee.getFixedSalary() + bonus);

        return employee;
    }
}
