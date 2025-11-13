package org.chandra.springdatajpamusclememory.topic4_relationships.task10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentCourseUnidirectionalRunner implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentCourseUnidirectionalRunner(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Course java = new Course("Java Fundamentals", "Core Java concepts", "Mr. Sharma");
        Course spring = new Course("Spring Framework", "Comprehensive Spring training", "Mrs. Priya");
        Course dbms = new Course("DBMS", "Relational databases and SQL", "Mr. Rao");

        Student chandra = new Student("Chandra", "chandra@uni.com");
        chandra.setCourses(List.of(java, spring));

        Student daniel = new Student("Daniel", "daniel@uni.com");
        daniel.setCourses(List.of(spring, dbms));

        Student asha = new Student("Asha", "asha@uni.com");
        asha.setCourses(List.of(java, dbms));

        studentRepository.saveAll(List.of(chandra, daniel, asha));

        System.out.println("Students: ");
        studentRepository.findAll().forEach(System.out::println);
        System.out.println();
        System.out.println("Courses: ");
        courseRepository.findAll().forEach(System.out::println);
    }
}
