package org.chandra.springdatajpamusclememory.topic3_customqueries.task10;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Long> {

    List<CustomerProfile> findByCity(String city);

    List<CustomerProfile> findByLoyaltyPoints(int minPoints);
}
