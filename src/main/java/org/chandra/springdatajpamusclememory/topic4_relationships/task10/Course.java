package org.chandra.springdatajpamusclememory.topic4_relationships.task10;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;
    private String title;
    private String description;
    private String instructor;

    public Course(String title, String description, String instructor) {
        this.title = title;
        this.description = description;
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", instructor='" + instructor + '\'' +
                '}';
    }

}
