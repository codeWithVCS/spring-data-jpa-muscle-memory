package org.chandra.springdatajpamusclememory.topic5_entitylifecycle.task6;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLifecycleRepository extends JpaRepository<ProductLifecycle,Long>
{
}
