package org.chandra.springdatajpamusclememory.topic3_customqueries.task9;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductInventoryRepository extends JpaRepository<ProductInventory, Long> {

    Page<ProductInventory> findByCategory(String category, Pageable pageable);

    List<ProductInventory> findBySupplier(String supplier, Sort sort);

    @Query("SELECT pi FROM ProductInventory pi WHERE pi.price >= :minPrice")
    Page<ProductInventory> findByPriceGreaterThanEqual(double minPrice, Pageable pageable);
}
