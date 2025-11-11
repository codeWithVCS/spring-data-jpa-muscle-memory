package org.chandra.springdatajpamusclememory.topic3_customqueries.task1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRecordRepository extends JpaRepository<EmployeeRecord,Long> {

    List<EmployeeRecord> findByDepartment(String department);
    List<EmployeeRecord> findBySalaryGreaterThan(double salary);
    List<EmployeeRecord> findByActiveTrue();
    long countByDepartment(String department);
    boolean existsByName(String name);

}
