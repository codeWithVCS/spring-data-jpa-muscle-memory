package org.chandra.springdatajpamusclememory.topic6_advanced.task6;

import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecifications {

    public static Specification<Employee> hasDepartment(String department){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("department"), department);
    }

    public static Specification<Employee> hasSalaryGreaterThan(double min){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("salary"), min);
    }

    public static Specification<Employee> nameContains(String keyword){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + keyword + "%");
    }
}
