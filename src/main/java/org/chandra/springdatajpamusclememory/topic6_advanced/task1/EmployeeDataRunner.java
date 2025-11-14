package org.chandra.springdatajpamusclememory.topic6_advanced.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDataRunner implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeDataRunner(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Employee e1 = new Employee("e1", "e1@mail.com", "d1", 75000.0);
        Employee e2 = new Employee("e2", "e2@mail.com", "d2", 48000.0);
        Employee e3 = new Employee("e3", "e3@mail.com", "d1", 96000.0);

        employeeRepository.save(e1);
        employeeRepository.save(e2);
        employeeRepository.save(e3);

        System.out.println("All Employees: ");
        employeeRepository.findAll().forEach(System.out::println);

        System.out.println("=== Employee Summary DTOs (Salary > 50000) ===");
        employeeRepository.findEmployeeSummariesByMinSalary(50000).forEach(System.out::println);
    }
}
