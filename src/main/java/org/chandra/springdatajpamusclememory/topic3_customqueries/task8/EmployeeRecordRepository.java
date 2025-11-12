package org.chandra.springdatajpamusclememory.topic3_customqueries.task8;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRecordRepository extends JpaRepository<EmployeeRecord,Long> {

    @Query("SELECT er FROM EmployeeRecord er WHERE er.active = true")
    List<EmployeeSummaryProjection> findActiveEmployeeSummaryProjection();

    List<EmployeeDetailsDTO> findByDepartment(String department);
}
