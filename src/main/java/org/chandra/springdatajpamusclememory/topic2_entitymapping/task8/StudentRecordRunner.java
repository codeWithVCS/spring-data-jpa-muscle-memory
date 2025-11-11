package org.chandra.springdatajpamusclememory.topic2_entitymapping.task8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentRecordRunner implements CommandLineRunner {

    private final StudentRecordRepository studentRecordRepository;

    @Autowired
    public StudentRecordRunner(StudentRecordRepository studentRecordRepository) {
        this.studentRecordRepository = studentRecordRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        StudentRecord sr1 = new StudentRecord("Chandra", "chandra@uni.com", "Spring Boot", "A");
        StudentRecord sr2 = new StudentRecord("Daniel", "daniel@uni.com", "JPA", "B");
        StudentRecord sr3 = new StudentRecord("Asha", "asha@uni.com", "Hibernate", "A");

        System.out.println("Saving Student Records");
        studentRecordRepository.save(sr1);
        studentRecordRepository.save(sr2);
        StudentRecord saved = studentRecordRepository.save(sr3);

        System.out.println("Retrieving all Student Records");
        studentRecordRepository.findAll().forEach(System.out::println);

        System.out.println("Fetching Student Record with ID: " +saved.getId());
        studentRecordRepository.findById(saved.getId());

        System.out.println("Updating Grade of Student Record with ID: " +saved.getId());
        Optional<StudentRecord> record = studentRecordRepository.findById(saved.getId());
        record.ifPresent(r -> {
            r.setGrade("A");
            studentRecordRepository.save(r);
        });

        System.out.println("Deleting Student Record with ID: " +saved.getId());
        studentRecordRepository.deleteById(saved.getId());

        System.out.println("Retrieving all Student Records");
        studentRecordRepository.findAll().forEach(System.out::println);

    }
}
