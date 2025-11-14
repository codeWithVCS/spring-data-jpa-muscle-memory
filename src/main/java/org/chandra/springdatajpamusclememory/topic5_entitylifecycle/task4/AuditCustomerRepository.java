package org.chandra.springdatajpamusclememory.topic5_entitylifecycle.task4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditCustomerRepository extends JpaRepository<AuditCustomer,Long> {
}
