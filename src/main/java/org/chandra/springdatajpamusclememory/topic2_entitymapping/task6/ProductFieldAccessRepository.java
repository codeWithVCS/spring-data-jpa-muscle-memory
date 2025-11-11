package org.chandra.springdatajpamusclememory.topic2_entitymapping.task6;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductFieldAccessRepository extends JpaRepository<ProductFieldAccess, Long> {
}
