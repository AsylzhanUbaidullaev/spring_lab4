package com.asylzhan.lab5.repo;

import com.asylzhan.lab5.entity.Employee;
import com.asylzhan.lab5.entity.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> getEmployeesByEmplType(EmployeeType employeeType);
}
