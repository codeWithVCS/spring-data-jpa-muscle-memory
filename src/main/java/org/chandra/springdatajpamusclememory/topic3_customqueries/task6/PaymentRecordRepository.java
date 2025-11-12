package org.chandra.springdatajpamusclememory.topic3_customqueries.task6;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRecordRepository extends JpaRepository<PaymentRecord,Long> {

    @Query("SELECT pm FROM PaymentRecord pm WHERE pm.method = (:#{#paymentRecord.method}) AND pm.status = (:#{#paymentRecord.status})")
    List<PaymentRecord> findRecordsByMatchingMethodAndStatus(PaymentRecord paymentRecord);

    @Query("SELECT pm FROM PaymentRecord pm WHERE pm.amount >= (:#{#minAmount})")
    List<PaymentRecord> findByAmountGreaterThanOrEqual(double minAmount);

    @Query("SELECT COUNT(pm) FROM PaymentRecord pm WHERE pm.method = :method AND pm.status = 'SUCCESS'")
    long countByMethodAndSuccess(String method);

}
