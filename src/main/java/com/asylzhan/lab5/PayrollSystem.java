package com.asylzhan.lab5;

import com.asylzhan.lab5.controller.EmployeeController;
import com.asylzhan.lab5.entity.Employee;
import com.asylzhan.lab5.service.SalaryCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class PayrollSystem {
    Scanner in = new Scanner(System.in);
    @Autowired
    private EmployeeController employeeController;
    @Autowired
    private SalaryCalculatorService salaryCalculatorService;

    public void add10PercentSalaryForSalariedCommission() {
        List<Employee> employees = employeeController.getAllSalariedCommission();
        for (int i = 0; i < employees.size(); i++) {
            Double oldSalary = employees.get(i).getFixedSalary();
            employees.get(i).setFixedSalary(oldSalary * 1.1);
            employeeController.updateEmployeeFixedSalary(employees.get(i), oldSalary);
        }
    }

    private void changeSalaryForSalariedEmployee() {
        List<Employee> employees = employeeController.getAllSalariedEmployee();

        for (int i = 0; i < employees.size(); i++) {
            System.out.println(i + ") " + employees.get(i).getName() + " (id=" + employees.get(i).getId() + ")");
        }
        System.out.print("chose employee: ");
        Integer indexEmployee = in.nextInt();
        Double oldSalary = employees.get(indexEmployee).getFixedSalary();
        System.out.print("input new salary: ");
        employees.get(indexEmployee).setFixedSalary(in.nextDouble());

        employeeController.updateEmployeeFixedSalary(employees.get(indexEmployee), oldSalary);
    }

    private void changeSalaryForHourlyEmployee() {
        List<Employee> employees = employeeController.getAllHourlyEmployee();

        for (int i = 0; i < employees.size(); i++) {
            System.out.println(i + ") " + employees.get(i).getName() + " (id=" + employees.get(i).getId() + ")");
        }
        System.out.print("chose employee: ");
        Integer indexEmployee = in.nextInt();
        Double oldSalary = employees.get(indexEmployee).getFixedSalary();
        System.out.print("input new salary hour: ");
        employees.get(indexEmployee).setHourRate(in.nextDouble());

        salaryCalculatorService.calculateHourlyEmployeeSalary(employees.get(indexEmployee));
        employeeController.updateEmployeeFixedSalary(employees.get(indexEmployee), oldSalary);
    }

    private void changeSalaryForCommissionEmployee() {
        List<Employee> employees = employeeController.getAllCommissionEmployee();

        for (int i = 0; i < employees.size(); i++) {
            System.out.println(i + ") " + employees.get(i).getName() + " (id=" + employees.get(i).getId() + ")");
        }
        System.out.print("chose employee: ");
        Integer indexEmployee = in.nextInt();
        Double oldSalary = employees.get(indexEmployee).getFixedSalary();
        System.out.print("input sale amount: ");
        Double saleAmount = in.nextDouble();

        salaryCalculatorService.calculateSalaryCommissionEmployee(employees.get(indexEmployee), saleAmount);
        employeeController.updateEmployeeFixedSalary(employees.get(indexEmployee), oldSalary);
    }

    private void changeSalaryForSalariedCommissionEmployee() {
        List<Employee> employees = employeeController.getAllSalariedCommission();

        for (int i = 0; i < employees.size(); i++) {
            System.out.println(i + ") " + employees.get(i).getName() + " (id=" + employees.get(i).getId() + ")");
        }

        System.out.print("chose employee: ");
        Integer indexEmployee = in.nextInt();
        Double oldSalary = employees.get(indexEmployee).getFixedSalary();
        System.out.print("input sale amount: ");
        Double saleAmount = in.nextDouble();
        salaryCalculatorService.calculateSalarySalariedCommissionEmployee(employees.get(indexEmployee), saleAmount);
        employeeController.updateEmployeeFixedSalary(employees.get(indexEmployee), oldSalary);
    }

    public void runPayrollSystem() {
        int choice = -1;

        while(choice != 0) {
            System.out.println("1. Adding 10% base salaries for all Salaried-Commission employees");
            System.out.println("2. change salary for Salaried employee");
            System.out.println("3. change salary for Hourly employee");
            System.out.println("4. change salary for Commission employee");
            System.out.println("5. change salary for Salaried-Commission employee");
            System.out.println("0. Exit");

            choice = in.nextInt();

            switch (choice) {
                case 1:
                    add10PercentSalaryForSalariedCommission();
                    break;
                case 2:
                    changeSalaryForSalariedEmployee();
                    break;
                case 3:
                    changeSalaryForHourlyEmployee();
                    break;
                case 4:
                    changeSalaryForCommissionEmployee();
                    break;
                case 5:
                    changeSalaryForSalariedCommissionEmployee();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Incorrect choice");
            }
        }
    }
}
