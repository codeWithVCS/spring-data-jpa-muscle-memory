package org.chandra.springdatajpamusclememory.topic4_relationships.task6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartmentEmployeeBidirectionalRunner implements CommandLineRunner {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

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

        Department finance = new Department("Finance", "Bangalore");
        Employee e5 = new Employee("Ravi", "ravi@corp.com", "Accountant");
        Employee e6 = new Employee("Kiran", "kiran@corp.com", "Analyst");
        e5.setDepartment(finance);
        e6.setDepartment(finance);
        finance.setEmployees(List.of(e5, e6));

        departmentRepository.save(it);
        departmentRepository.save(hr);
        departmentRepository.save(finance);

        System.out.println("Departments: ");
        departmentRepository.findAll().forEach(System.out::println);
        System.out.println();
        System.out.println("Employees: ");
        employeeRepository.findAll().forEach(System.out::println);
    }
}
