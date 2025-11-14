package org.chandra.springdatajpamusclememory.topic5_entitylifecycle.task7;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallbackAuditRepository extends JpaRepository<CallbackAuditEntity,Long> {
}
