package org.chandra.springdatajpamusclememory.topic6_advanced.task1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("SELECT new org.chandra.springdatajpamusclememory.topic6_advanced.task1.EmployeeSummaryDTO(e.name, e.department, e.salary) FROM Employee e WHERE e.salary > :minSalary")
    List<EmployeeSummaryDTO> findEmployeeSummariesByMinSalary(@Param("minSalary") double minSalary);

}
