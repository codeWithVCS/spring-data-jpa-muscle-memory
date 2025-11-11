package org.chandra.springdatajpamusclememory.topic2_entitymapping.task7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductPropertyAccessRunner implements CommandLineRunner {

    private final ProductPropertyAccessRepository productPropertyAccessRepository;

    @Autowired
    public ProductPropertyAccessRunner(ProductPropertyAccessRepository productPropertyAccessRepository) {
        this.productPropertyAccessRepository = productPropertyAccessRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        ProductPropertyAccess p1 = new ProductPropertyAccess("Laptop", 50000.0);
        ProductPropertyAccess p2 = new ProductPropertyAccess("Tablet", 30000.0);
        ProductPropertyAccess p3 = new ProductPropertyAccess("Mobile", 20000.0);

        p1.setDiscountedPrice();
        p2.setDiscountedPrice();
        p3.setDiscountedPrice();

        productPropertyAccessRepository.save(p1);
        productPropertyAccessRepository.save(p2);
        productPropertyAccessRepository.save(p3);

        productPropertyAccessRepository.findAll().forEach(System.out::println);
    }
}
