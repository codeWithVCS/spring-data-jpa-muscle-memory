package org.chandra.springdatajpamusclememory.topic6_advanced.task3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDataRunner implements CommandLineRunner {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeDataRunner(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Employee e1 = new Employee("Chandra","chandra@corp.com","IT",90000);
        Employee e2 = new Employee("Asha","asha@corp.com","HR",50000);
        Employee e3 = new Employee("Daniel", "daniel@corp.com","IT",75000);

        employeeRepository.save(e1);
        employeeRepository.save(e2);
        employeeRepository.save(e3);

        System.out.println("=== All Employees ===");
        employeeRepository.findAll().forEach(System.out::println);
        System.out.println();
        System.out.println("=== Projection: Salary > 60000 ===");
        employeeRepository.findBySalaryGreaterThan(60000).forEach(System.out::println);
        System.out.println();
        System.out.println("=== Projection: Department = IT ===");
        employeeRepository.findByDepartmentProjection("IT").forEach(System.out::println);
    }
}
