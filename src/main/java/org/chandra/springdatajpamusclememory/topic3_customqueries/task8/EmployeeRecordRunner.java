package org.chandra.springdatajpamusclememory.topic3_customqueries.task8;

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
        employeeRecordRepository.save(new EmployeeRecord("Chandra", "IT", "Developer", 75000.0, true));
        employeeRecordRepository.save(new EmployeeRecord("Daniel", "HR", "Recruiter", 50000.0, true));
        employeeRecordRepository.save(new EmployeeRecord("Asha", "Finance", "Analyst", 60000.0, false));
        employeeRecordRepository.save(new EmployeeRecord("Ravi", "IT", "Manager", 90000.0, true));
        employeeRecordRepository.save(new EmployeeRecord("Neha", "Finance", "Auditor", 55000.0, true));
        employeeRecordRepository.save(new EmployeeRecord("Kiran", "Sales", "Executive", 45000.0, true));
        employeeRecordRepository.save(new EmployeeRecord("Divya", "IT", "Tester", 40000.0, false));

        System.out.println("Active Employee Summaries: ");
        employeeRecordRepository.findActiveEmployeeSummaryProjection().forEach(System.out::println);
        System.out.println();
        System.out.println("Employee Details for Department = 'IT': ");
        employeeRecordRepository.findByDepartment("IT").forEach(System.out::println);
    }
}
