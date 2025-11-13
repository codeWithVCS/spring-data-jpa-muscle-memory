package org.chandra.springdatajpamusclememory.topic4_relationships.task5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartmentEmployeeRunner implements CommandLineRunner {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public DepartmentEmployeeRunner(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Department it = new Department("IT", "Hyderabad");
        it.setEmployees(List.of(
                new Employee("Chandra", "chandra@corp.com", "Developer"),
                new Employee("Asha", "asha@corp.com", "Tester")
        ));

        Department hr = new Department("HR", "Chennai");
        hr.setEmployees(List.of(
                new Employee("Daniel", "daniel@corp.com", "HR Specialist"),
                new Employee("Divya", "divya@corp.com", "Recruiter")
        ));

        Department finance = new Department("Finance", "Bangalore");
        finance.setEmployees(List.of(
                new Employee("Ravi", "ravi@corp.com", "Accountant"),
                new Employee("Kiran", "kiran@corp.com", "Analyst")
        ));

        departmentRepository.save(it);
        departmentRepository.save(hr);
        departmentRepository.save(finance);

        System.out.println("Departments: ");
        departmentRepository.findAll().forEach(System.out::println);
    }
}
