package org.chandra.springdatajpamusclememory.topic6_advanced.task4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    <T> List<T> findByDepartment(String department, Class<T> type);
}
