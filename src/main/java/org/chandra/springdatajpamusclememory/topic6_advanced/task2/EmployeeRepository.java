package org.chandra.springdatajpamusclememory.topic6_advanced.task2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(name = "Employee.salarySummaryNative", nativeQuery = true)
    List<EmployeeSummaryDTO> findEmployeeSummariesNative(@Param("minSalary") double minSalary);
}
