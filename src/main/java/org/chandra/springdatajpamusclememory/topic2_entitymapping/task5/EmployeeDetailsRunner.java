package org.chandra.springdatajpamusclememory.topic2_entitymapping.task5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDetailsRunner implements CommandLineRunner {

    private final EmployeeDetailsRepository employeeDetailsRepository;

    @Autowired
    public EmployeeDetailsRunner(EmployeeDetailsRepository employeeDetailsRepository) {
        this.employeeDetailsRepository = employeeDetailsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        EmployeeDetails ed1 = new EmployeeDetails("A", "IT", 60000.0);
        EmployeeDetails ed2 = new EmployeeDetails("B", "HR", 50000.0);
        EmployeeDetails ed3 = new EmployeeDetails("C", "SUPPORT", 30000.0);

        ed1.setBonusPercentage(10);
        ed1.setNetSalary(ed1.calculateNetSalary());

        ed2.setBonusPercentage(8);
        ed2.setNetSalary(ed2.calculateNetSalary());

        ed3.setBonusPercentage(5);
        ed3.setNetSalary(ed3.calculateNetSalary());

        employeeDetailsRepository.save(ed1);
        employeeDetailsRepository.save(ed2);
        employeeDetailsRepository.save(ed3);

        employeeDetailsRepository.findAll().forEach(System.out::println);
    }
}
