package org.chandra.springdatajpamusclememory.topic3_customqueries.task1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employee_records")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String department;
    private double salary;
    private boolean active;

    public EmployeeRecord(String name, String department, double salary, boolean active) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.active = active;
    }
}
