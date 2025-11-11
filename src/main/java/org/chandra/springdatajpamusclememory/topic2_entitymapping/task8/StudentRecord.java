package org.chandra.springdatajpamusclememory.topic2_entitymapping.task8;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "students")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String email;
    private String course;
    private String grade;

    public StudentRecord(String name, String email, String course, String grade) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.grade = grade;
    }
}
