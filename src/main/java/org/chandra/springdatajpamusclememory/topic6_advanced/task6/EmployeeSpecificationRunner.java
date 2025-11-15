package org.chandra.springdatajpamusclememory.topic6_advanced.task6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeSpecificationRunner implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeSpecificationRunner(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Employee chandra = new Employee("Chandra", "chandra@corp.com", "IT", 90000);
        Employee asha = new Employee("Asha", "asha@corp.com", "HR", 50000);
        Employee daniel = new Employee("Daniel", "daniel@corp.com", "IT", 60000);
        Employee ram = new Employee("Ram","ram@corp.com","SUPPORT",40000);
        Employee sita = new Employee("Sita", "sita@corp.com","HR", 50000);

        employeeRepository.saveAll(List.of(chandra, asha, daniel, ram, sita));

        System.out.println("All IT employees: ");
        List<Employee> itEmployees = employeeRepository.findAll(Specification.where(EmployeeSpecifications.hasDepartment("IT")));
        itEmployees.forEach(System.out::println);
        System.out.println();
        System.out.println("Employees with salary > 60000: ");
        List<Employee> employeeSalaryThreshold = employeeRepository.findAll(Specification.where(EmployeeSpecifications.hasSalaryGreaterThan(60000)));
        employeeSalaryThreshold.forEach(System.out::println);
        System.out.println();
        System.out.println("Employees containing \"a\" in their name: ");
        List<Employee> containsAinName = employeeRepository.findAll(Specification.where(EmployeeSpecifications.nameContains("a")));
        containsAinName.forEach(System.out::println);
        System.out.println("Combination filters (IT + salary > 60000 + keyword \"a\"): ");
        List<Employee> customSearch = employeeRepository.findAll(
                Specification.where(EmployeeSpecifications.hasDepartment("IT"))
                        .and(EmployeeSpecifications.hasSalaryGreaterThan(60000))
                        .and(EmployeeSpecifications.nameContains("a"))
        );
        customSearch.forEach(System.out::println);
    }
}
