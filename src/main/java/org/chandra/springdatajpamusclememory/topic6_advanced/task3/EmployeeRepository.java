package org.chandra.springdatajpamusclememory.topic6_advanced.task3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<EmployeeProjection> findBySalaryGreaterThan(double salary);

    @Query("SELECT e.name AS name, e.department AS department, e.salary AS salary FROM Employee e WHERE e.department = :department")
    List<EmployeeProjection> findByDepartmentProjection(@Param("department") String department);

}
