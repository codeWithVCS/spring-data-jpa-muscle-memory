package org.chandra.springdatajpamusclememory.topic2_entitymapping.task8;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRecordRepository extends CrudRepository<StudentRecord,Long> {
}
