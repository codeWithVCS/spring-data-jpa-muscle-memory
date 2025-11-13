package org.chandra.springdatajpamusclememory.topic4_relationships.task1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,  unique = true)
    private String email;
    private String designation;

    public Employee(String name, String email, String designation) {
        this.name = name;
        this.email = email;
        this.designation = designation;
    }
}
