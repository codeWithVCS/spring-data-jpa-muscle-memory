package org.chandra.springdatajpamusclememory.topic6_advanced.task4;

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
        Employee chandra = new Employee("Chandra", "chandra@corp.com", "IT", 90000);
        Employee asha = new Employee("Asha", "asha@corp.com", "HR", 50000);
        Employee daniel = new Employee("Daniel","daniel@corp.com", "IT", 60000);

        employeeRepository.saveAll(List.of(chandra,asha,daniel));

        System.out.println("=== Full Entity Fetch ===");
        employeeRepository.findAll().forEach(System.out::println);
        System.out.println();
        System.out.println("\n=== Projection: EmployeeBasicView ===");
        employeeRepository.findByDepartment("IT", EmployeeBasicView.class)
                .forEach(p -> System.out.println("Name: " + p.getName() + ", Department: " + p.getDepartment()));

        System.out.println("\n=== Projection: EmployeeSalaryView ===");
        employeeRepository.findByDepartment("IT", EmployeeSalaryView.class)
                .forEach(p -> System.out.println("Name: " + p.getName() + ", Salary: " + p.getSalary()));
    }
}
