package org.chandra.springdatajpamusclememory.topic5_entitylifecycle.task2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProductLifecycleRunner implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Autowired
    public ProductLifecycleRunner(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        System.out.println("=== Demonstrating Entity Lifecycle Callbacks ===");

        // Step 1: Create and persist product
        Product product = new Product("Laptop", 85000.0);
        productRepository.save(product);

        System.out.println("\n--- Product persisted ---");
        productRepository.findAll().forEach(System.out::println);

        // Step 2: Update the product price
        product.setPrice(90000.0);
        productRepository.save(product);

        System.out.println("\n--- Product updated ---");
        productRepository.findAll().forEach(System.out::println);

        // Step 3: Fetch the product from DB (triggers @PostLoad)
        System.out.println("\n--- Loading product from DB ---");
        Product loaded = productRepository.findById(product.getId()).orElseThrow();
        System.out.println("Fetched Product: " + loaded);

        // Step 4: Delete the product (triggers @PreRemove, @PostRemove)
        System.out.println("\n--- Deleting product ---");
        productRepository.delete(loaded);

        System.out.println("\n=== Lifecycle Demonstration Complete ===");
    }
}
