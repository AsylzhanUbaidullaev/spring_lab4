package com.asylzhan.lab5.handler;

import com.asylzhan.lab5.event.SalaryChangeEvent;
import org.springframework.context.ApplicationListener;

public class SalaryChangeEventHandler implements ApplicationListener<SalaryChangeEvent> {
    @Override
    public void onApplicationEvent(SalaryChangeEvent salaryChangeEvent) {
        System.out.println("\nSalaryChangeEventHandler.onApplicationEvent");
        System.out.println("Salary update: " + salaryChangeEvent.getEmployee().getFixedSalary());
        System.out.println("Salary old:    " + salaryChangeEvent.getOldSalary());
        System.out.println("Employee:      " + salaryChangeEvent.getEmployee());
    }
}
