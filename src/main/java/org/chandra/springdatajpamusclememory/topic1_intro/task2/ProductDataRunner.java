package org.chandra.springdatajpamusclememory.topic1_intro.task2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductDataRunner implements CommandLineRunner {
    private ProductRepository productRepository;
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Product p1 = new Product("Laptop",50000, "Electronics");
        Product p2 = new Product("Phone",27000, "Electronics");
        Product p3 = new Product("Keyboard", 1000, "Electronics");

        productRepository.save(p1);
        productRepository.save(p2);
        productRepository.save(p3);

        System.out.println("All products: ");
        productRepository.findAll().forEach(System.out::println);

        System.out.println("Product with id 1: ");
        productRepository.findById(1L).ifPresent(System.out::println);

        System.out.println("Deleting product with ID 2");
        productRepository.deleteById(2L);

        System.out.println("All products: ");
        productRepository.findAll().forEach(System.out::println);

    }
}
