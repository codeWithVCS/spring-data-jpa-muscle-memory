package org.chandra.springdatajpamusclememory.topic6_advanced.task5;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeOpenProjection {

    String getName();

    @Value("#{target.department + ' Department '}")
    String getFormattedDepartment();

    @Value("#{T(java.lang.Math).round(target.salary)}")
    Long getRoundedSalary();

    @Value("#{target.name +' earns ' + target.salary + ' in ' + target.department + ' Department'}")
    String getSummary();
}
