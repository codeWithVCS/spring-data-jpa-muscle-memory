package org.chandra.springdatajpamusclememory.topic2_entitymapping.task4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerProfileRepository extends JpaRepository<CustomerProfile,Long> {
}
