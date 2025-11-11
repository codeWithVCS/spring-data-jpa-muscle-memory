package org.chandra.springdatajpamusclememory.topic2_entitymapping.task7;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPropertyAccessRepository extends JpaRepository<ProductPropertyAccess,Long> {
}
