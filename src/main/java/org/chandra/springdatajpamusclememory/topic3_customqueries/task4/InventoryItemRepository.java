package org.chandra.springdatajpamusclememory.topic3_customqueries.task4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

    @Query(value = "SELECT * FROM inventory_items WHERE category = ?1", nativeQuery = true)
    List<InventoryItem> findByCategory(String category);

    @Query(value = "SELECT * FROM inventory_items WHERE quantity < ?1",  nativeQuery = true)
    List<InventoryItem> findLowStockItems(int threshold);

    @Query(value = "SELECT supplier, COUNT(*) AS total_items FROM inventory_items GROUP BY supplier",  nativeQuery = true)
    List<Object[]> countItemsBySupplier();

    @Query(value = "SELECT AVG(unit_price) FROM inventory_items WHERE category = ?1",  nativeQuery = true)
    double findAveragePriceByCategory(String category);

    @Query(value = "SELECT * FROM inventory_items ORDER BY unit_price DESC LIMIT 3", nativeQuery = true)
    List<InventoryItem> findTop3ExpensiveItems();
}
