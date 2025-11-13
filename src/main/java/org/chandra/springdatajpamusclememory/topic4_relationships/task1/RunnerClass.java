package org.chandra.springdatajpamusclememory.topic4_relationships.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunnerClass implements CommandLineRunner {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public RunnerClass(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Department it =  new Department("IT","Hyderabad");
        Department hr =  new Department("HR","Chennai");
        Department finance =  new Department("Finance","Bangalore");

        Employee chandra = new Employee("Chandra", "chandra@corp.com", "Developer");
        Employee daniel = new Employee("Daniel", "daniel@corp.com", "Analyst");
        Employee asha = new Employee("Asha", "asha@corp.com", "Manager");

        departmentRepository.save(it);
        departmentRepository.save(hr);
        departmentRepository.save(finance);

        employeeRepository.save(chandra);
        employeeRepository.save(daniel);
        employeeRepository.save(asha);

        System.out.println("Departments: ");
        departmentRepository.findAll().forEach(System.out::println);
        System.out.println();
        System.out.println("Employees: ");
        employeeRepository.findAll().forEach(System.out::println);
    }
}
