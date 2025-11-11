package org.chandra.springdatajpamusclememory.topic3_customqueries.task5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderTransactionRepository extends JpaRepository<OrderTransaction,Long> {

    @Query("SELECT o FROM OrderTransaction o WHERE o.customerName = ?1 AND o.status = ?2")
    List<OrderTransaction> findByCustomerAndStatus(String customerName, String status);

    @Query("SELECT o FROM OrderTransaction  o WHERE o.amount >= ?1")
    List<OrderTransaction> findByAmountGreaterThanEqual(double minAmount);

    @Query(value = "SELECT COUNT(*) FROM order_transactions WHERE payment_method = ?1", nativeQuery = true)
    long countTransactionsByPaymentMethod(String paymentMethod);
}
