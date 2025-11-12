package org.chandra.springdatajpamusclememory.topic3_customqueries.task9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductInventoryRunner implements CommandLineRunner {

    private final ProductInventoryRepository productInventoryRepository;

    @Autowired
    public ProductInventoryRunner(ProductInventoryRepository productInventoryRepository) {
        this.productInventoryRepository = productInventoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        productInventoryRepository.save(new ProductInventory("Laptop", "Electronics", 85000.0, 10, "TechCorp"));
        productInventoryRepository.save(new ProductInventory("Smartphone", "Electronics", 50000.0, 20, "TechCorp"));
        productInventoryRepository.save(new ProductInventory("Tablet", "Electronics", 30000.0, 15, "HomeNeeds"));
        productInventoryRepository.save(new ProductInventory("TV", "Electronics", 75000.0, 5, "TechCorp"));
        productInventoryRepository.save(new ProductInventory("Desk", "Furniture", 9000.0, 8, "FurniCraft"));
        productInventoryRepository.save(new ProductInventory("Chair", "Furniture", 4000.0, 12, "FurniCraft"));
        productInventoryRepository.save(new ProductInventory("Rice Cooker", "Appliances", 6000.0, 25, "HomeNeeds"));
        productInventoryRepository.save(new ProductInventory("Refrigerator", "Appliances", 55000.0, 6, "HomeNeeds"));
        productInventoryRepository.save(new ProductInventory("Microwave", "Appliances", 15000.0, 10, "HomeNeeds"));
        productInventoryRepository.save(new ProductInventory("Pen", "Stationery", 20.0, 200, "OfficeMart"));
        productInventoryRepository.save(new ProductInventory("Notebook", "Stationery", 100.0, 150, "OfficeMart"));
        productInventoryRepository.save(new ProductInventory("Marker", "Stationery", 50.0, 120, "OfficeMart"));

        Pageable electronicsPageRequest1 = PageRequest.of(0, 2);
        Page<ProductInventory> electronicsPage1 = productInventoryRepository.findByCategory("Electronics", electronicsPageRequest1);
        System.out.println("Page 1 – Electronics Products: ");
        electronicsPage1.getContent().forEach(System.out::println);

        Pageable electronicsPageRequest2 = PageRequest.of(1,2);
        Page<ProductInventory> electronicsPage2 = productInventoryRepository.findByCategory("Electronics", electronicsPageRequest2);
        System.out.println("Page 2 – Electronics Products: ");
        electronicsPage2.getContent().forEach(System.out::println);

        System.out.println();

        Sort descSort =Sort.by("price").descending();
        Sort ascSort = Sort.by("price").ascending();
        System.out.println("TechCorp Products sorted by Price ASC: ");
        List<ProductInventory> ascSortedList = productInventoryRepository.findBySupplier("TechCorp", ascSort);
        ascSortedList.forEach(System.out::println);

        System.out.println();

        System.out.println("TechCorp Products sorted by Price DESC: ");
        List<ProductInventory> descSortedList = productInventoryRepository.findBySupplier("TechCorp", descSort);
        descSortedList.forEach(System.out::println);

        System.out.println();

        Pageable pricePage1 = PageRequest.of(0, 3);
        Pageable pricePage2 = PageRequest.of(1, 3);
        Pageable pricePage3 = PageRequest.of(2, 3);

        Page<ProductInventory> p1 = productInventoryRepository.findByPriceGreaterThanEqual(10000, pricePage1);
        Page<ProductInventory> p2 = productInventoryRepository.findByPriceGreaterThanEqual(10000, pricePage2);
        Page<ProductInventory> p3 = productInventoryRepository.findByPriceGreaterThanEqual(10000, pricePage3);
        System.out.println("Products priced >= 10000 (Page 1): ");
        p1.getContent().forEach(System.out::println);
        System.out.println();
        System.out.println("Products priced >= 10000 (Page 2): ");
        p2.getContent().forEach(System.out::println);
        System.out.println();
        System.out.println("Products priced >= 10000 (Page 3): ");
        p3.getContent().forEach(System.out::println);
        System.out.println();
    }
}
