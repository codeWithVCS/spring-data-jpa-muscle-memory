package org.chandra.springdatajpamusclememory.topic4_relationships.task7;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;
    private String name;
    private String email;
    private String designation;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee(String name, String email, String designation){
        this.name = name;
        this.email = email;
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", designation='" + designation + '\'' +
                ", department=" + (department != null ? department.getName() : "null") +
                '}';
    }

}
