package org.chandra.springdatajpamusclememory.topic3_customqueries.task8;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeDetailsDTO {
    private String name;
    private String designation;
    private double salary;

    public EmployeeDetailsDTO(String name, String designation, double salary) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }
}
