package org.chandra.springdatajpamusclememory.topic4_relationships.task7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDepartmentRunner implements CommandLineRunner {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeDepartmentRunner(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Department it = new Department("IT", "Hyderabad");
        Department hr = new Department("HR", "Chennai");
        Department finance = new Department("Finance", "Bangalore");

        departmentRepository.save(it);
        departmentRepository.save(hr);
        departmentRepository.save(finance);

        Employee e1 = new Employee("Chandra", "chandra@corp.com", "Developer");
        e1.setDepartment(it);
        Employee e2 = new Employee("Asha", "asha@corp.com", "Tester");
        e2.setDepartment(it);
        Employee e3 = new Employee("Daniel", "daniel@corp.com", "HR Specialist");
        e3.setDepartment(hr);
        Employee e4 = new Employee("Divya", "divya@corp.com", "Recruiter");
        e4.setDepartment(hr);
        Employee e5 = new Employee("Ravi", "ravi@corp.com", "Accountant");
        e5.setDepartment(finance);

        employeeRepository.saveAll(List.of(e1, e2, e3, e4, e5));

        System.out.println("Departments: ");
        departmentRepository.findAll().forEach(System.out::println);

        System.out.println();
        System.out.println();

        System.out.println("Employees: ");
        employeeRepository.findAll().forEach(System.out::println);
    }
}
