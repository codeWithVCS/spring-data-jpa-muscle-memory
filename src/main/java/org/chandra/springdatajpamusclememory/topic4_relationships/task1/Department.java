package org.chandra.springdatajpamusclememory.topic4_relationships.task1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String location;

    public Department(String name, String location) {
        this.name = name;
        this.location = location;
    }
}
