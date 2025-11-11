package org.chandra.springdatajpamusclememory.topic2_entitymapping.task5;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employee_details")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String department;
    private double salary;
    @Transient
    private double bonusPercentage;
    @Transient
    private double netSalary;

    public EmployeeDetails(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public double calculateNetSalary(){
        return salary + (salary * bonusPercentage/100);
    }
}
