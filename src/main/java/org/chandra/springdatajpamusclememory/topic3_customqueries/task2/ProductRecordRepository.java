package org.chandra.springdatajpamusclememory.topic3_customqueries.task2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRecordRepository extends JpaRepository<ProductRecord,Long> {

    List<ProductRecord> findByCategoryAndAvailableTrue(String category);
    List<ProductRecord> findByPriceBetween(double min, double max);
    List<ProductRecord> findByCategoryOrPriceLessThan(String category, double price);
    List<ProductRecord> findByAvailableFalseOrderByPriceDesc();
    List<ProductRecord> findTop3ByOrderByPriceDesc();
}
