package org.chandra.springdatajpamusclememory.topic1_intro.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDataLoader implements CommandLineRunner {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        Employee e1 = new Employee("Chandra", "IT");
        Employee e2 = new Employee("Daniel", "IT");
        Employee e3 = new Employee("Danny", "SALES");

        employeeRepository.save(e1);
        employeeRepository.save(e2);
        employeeRepository.save(e3);

        employeeRepository.findAll().forEach(System.out::println);
    }
}
