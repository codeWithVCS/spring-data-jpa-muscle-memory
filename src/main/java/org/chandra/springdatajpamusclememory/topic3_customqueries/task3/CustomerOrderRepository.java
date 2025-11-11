package org.chandra.springdatajpamusclememory.topic3_customqueries.task3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

    @Query("SELECT c FROM CustomerOrder c WHERE c.status = ?1")
    public List<CustomerOrder> findByStatus(String status);

    @Query("SELECT c FROM CustomerOrder  c WHERE c.pricePerUnit > ?1 AND c.quantity >= ?2")
    List<CustomerOrder> findExpensiveOrder(double minPrice, int minQuantity);

    @Query("SELECT c.customerName, c.productName FROM CustomerOrder c WHERE c.status = 'DELIVERED'")
    List<Object[]> findDeliveredOrderDetails();

    @Query("SELECT COUNT(c) FROM CustomerOrder c WHERE c.status = ?1")
    long countByStatus(String status);

    @Query("SELECT AVG(c.pricePerUnit * c.quantity) FROM CustomerOrder c")
    double findAverageOrderValue();
}
