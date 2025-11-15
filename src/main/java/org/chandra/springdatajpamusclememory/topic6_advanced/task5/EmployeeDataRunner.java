package org.chandra.springdatajpamusclememory.topic6_advanced.task5;

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
        Employee daniel = new Employee("Daniel", "daniel@corp.com", "IT", 60000);

        employeeRepository.saveAll(List.of(chandra, asha, daniel));

        System.out.println("=== Open Projection: Computed Fields ===");
        employeeRepository.findByDepartment("IT").forEach(p -> {
            System.out.println("Name: " + p.getName());
            System.out.println("Formatted Department: " + p.getFormattedDepartment());
            System.out.println("Rounded Salary: " + p.getRoundedSalary());
            System.out.println("Summary: " + p.getSummary());
            System.out.println();
        });
    }
}
