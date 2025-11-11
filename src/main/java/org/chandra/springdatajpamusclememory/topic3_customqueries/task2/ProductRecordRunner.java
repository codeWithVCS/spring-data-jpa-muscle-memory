package org.chandra.springdatajpamusclememory.topic3_customqueries.task2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductRecordRunner implements CommandLineRunner {

    private final ProductRecordRepository productRecordRepository;

    @Autowired
    public ProductRecordRunner(ProductRecordRepository productRecordRepository) {
        this.productRecordRepository = productRecordRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        productRecordRepository.save(new ProductRecord("Laptop", "Electronics", 80000.0, true));
        productRecordRepository.save(new ProductRecord("Smartphone", "Electronics", 50000.0, true));
        productRecordRepository.save(new ProductRecord("TV", "Electronics", 75000.0, false));
        productRecordRepository.save(new ProductRecord("Desk", "Furniture", 12000.0, true));
        productRecordRepository.save(new ProductRecord("Chair", "Furniture", 5000.0, true));
        productRecordRepository.save(new ProductRecord("Refrigerator", "Appliances", 60000.0, false));
        productRecordRepository.save(new ProductRecord("Notebook", "Stationery", 150.0, true));
        productRecordRepository.save(new ProductRecord("Pencil", "Stationery", 20.0, true));

        System.out.println("Products in Electronics and available: ");
        productRecordRepository.findByCategoryAndAvailableTrue("Electronics").forEach(System.out::println);
        System.out.println();
        System.out.println("Products priced between 100 and 500: ");
        productRecordRepository.findByPriceBetween(100, 500).forEach(System.out::println);
        System.out.println();
        System.out.println("Products in Grocery or priced < 200: ");
        productRecordRepository.findByCategoryOrPriceLessThan("Grocery", 200).forEach(System.out::println);
        System.out.println();
        System.out.println("Unavailable products sorted by price (desc): ");
        productRecordRepository.findByAvailableFalseOrderByPriceDesc().forEach(System.out::println);
        System.out.println();
        System.out.println("Top 3 most expensive products: ");
        productRecordRepository.findTop3ByOrderByPriceDesc().forEach(System.out::println);
    }
}
