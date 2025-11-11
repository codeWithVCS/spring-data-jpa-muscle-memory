package org.chandra.springdatajpamusclememory.topic3_customqueries.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRecordRunner implements CommandLineRunner {

    private final EmployeeRecordRepository employeeRecordRepository;

    @Autowired
    public EmployeeRecordRunner(EmployeeRecordRepository employeeRecordRepository) {
        this.employeeRecordRepository = employeeRecordRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        EmployeeRecord er1 = new EmployeeRecord("A", "IT", 50000.0, true);
        EmployeeRecord er2 = new EmployeeRecord("B", "HR", 70000.0, true);
        EmployeeRecord er3 = new EmployeeRecord("C", "IT", 25000.0, true);
        EmployeeRecord er4 = new EmployeeRecord("D", "HR", 27000.0, true);
        EmployeeRecord er5 = new EmployeeRecord("E", "IT", 50000.0, false);

        employeeRecordRepository.save(er1);
        employeeRecordRepository.save(er2);
        employeeRecordRepository.save(er3);
        employeeRecordRepository.save(er4);
        employeeRecordRepository.save(er5);

        System.out.println("Employees in IT department: ");
        employeeRecordRepository.findByDepartment("IT").forEach(System.out::println);

        System.out.println();

        System.out.println("Employees with Salary > 50000: ");
        employeeRecordRepository.findBySalaryGreaterThan(50000).forEach(System.out::println);

        System.out.println();

        System.out.println("Active Employees: ");
        employeeRecordRepository.findByActiveTrue().forEach(System.out::println);

        System.out.println();

        long count = employeeRecordRepository.countByDepartment("HR");
        System.out.println("Count of HR department Employees: " + count);

        System.out.println("Does Asha exist? " + employeeRecordRepository.existsByName("Asha"));

    }
}
