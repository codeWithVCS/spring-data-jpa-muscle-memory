package org.chandra.springdatajpamusclememory.topic4_relationships.task8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartmentEmployeeBidirectionalRunner implements CommandLineRunner {

    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public DepartmentEmployeeBidirectionalRunner(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        Department it = new Department("IT", "Hyderabad");
        Employee e1 = new Employee("Chandra", "chandra@corp.com", "Developer");
        Employee e2 = new Employee("Asha", "asha@corp.com", "Tester");
        e1.setDepartment(it);
        e2.setDepartment(it);
        it.setEmployees(List.of(e1, e2));

        Department hr = new Department("HR", "Chennai");
        Employee e3 = new Employee("Daniel", "daniel@corp.com", "HR Specialist");
        Employee e4 = new Employee("Divya", "divya@corp.com", "Recruiter");
        e3.setDepartment(hr);
        e4.setDepartment(hr);
        hr.setEmployees(List.of(e3, e4));

        departmentRepository.saveAll(List.of(it, hr));

        System.out.println("Departments: ");
        departmentRepository.findAll().forEach(System.out::println);
        System.out.println();
        System.out.println("Employees: ");
        employeeRepository.findAll().forEach(System.out::println);
    }
}
