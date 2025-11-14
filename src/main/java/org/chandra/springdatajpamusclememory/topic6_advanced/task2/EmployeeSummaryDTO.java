package org.chandra.springdatajpamusclememory.topic6_advanced.task2;

import lombok.ToString;

@ToString
public class EmployeeSummaryDTO {
    private String name;
    private String department;
    private double salary;

    public EmployeeSummaryDTO(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}
