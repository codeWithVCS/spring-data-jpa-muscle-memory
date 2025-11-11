package org.chandra.springdatajpamusclememory.topic2_entitymapping.task6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductFieldAccessRunner implements CommandLineRunner {

    private ProductFieldAccessRepository productFieldAccessRepository;

    @Autowired
    public ProductFieldAccessRunner(ProductFieldAccessRepository productFieldAccessRepository) {
        this.productFieldAccessRepository = productFieldAccessRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        ProductFieldAccess p1 = new ProductFieldAccess("Laptop", 50000.0);
        ProductFieldAccess p2 = new ProductFieldAccess("Tablet", 30000.0);
        ProductFieldAccess p3 = new ProductFieldAccess("Mobile", 27000.0);

        p1.setDiscount(20);
        p2.setDiscount(10);
        p3.setDiscount(10);

        productFieldAccessRepository.save(p1);
        productFieldAccessRepository.save(p2);
        productFieldAccessRepository.save(p3);

        productFieldAccessRepository.findAll().forEach(System.out::println);
    }
}
