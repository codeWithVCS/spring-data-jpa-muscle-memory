package org.chandra.springdatajpamusclememory.topic6_advanced.task1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
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
