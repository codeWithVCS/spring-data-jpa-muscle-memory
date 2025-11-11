package org.chandra.springdatajpamusclememory.topic3_customqueries.task4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class InventoryItemRunner implements CommandLineRunner {

    private final InventoryItemRepository inventoryItemRepository;

    @Autowired
    public InventoryItemRunner(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        inventoryItemRepository.save(new InventoryItem("Laptop", "Electronics", 10, 80000.0, "TechCorp"));
        inventoryItemRepository.save(new InventoryItem("Smartphone", "Electronics", 15, 50000.0, "TechCorp"));
        inventoryItemRepository.save(new InventoryItem("TV", "Electronics", 5, 70000.0, "HomeNeeds"));
        inventoryItemRepository.save(new InventoryItem("Rice Bag", "Grocery", 50, 1200.0, "HomeNeeds"));
        inventoryItemRepository.save(new InventoryItem("Notebook", "Stationery", 30, 150.0, "OfficeMart"));
        inventoryItemRepository.save(new InventoryItem("Pen", "Stationery", 2, 25.0, "OfficeMart"));
        inventoryItemRepository.save(new InventoryItem("Desk", "Furniture", 8, 9000.0, "FurniCraft"));
        inventoryItemRepository.save(new InventoryItem("Chair", "Furniture", 12, 4000.0, "FurniCraft"));
        inventoryItemRepository.save(new InventoryItem("Pencil", "Stationery", 3, 15.0, "OfficeMart"));

        System.out.println("Items in Electronics category: ");
        inventoryItemRepository.findByCategory("Electronics").forEach(System.out::println);
        System.out.println();
        System.out.println("Low stock items (threshold < 5): ");
        inventoryItemRepository.findLowStockItems(5).forEach(System.out::println);
        System.out.println();
        System.out.println("Item count by supplier: ");
        inventoryItemRepository.countItemsBySupplier().forEach(System.out::println);
        System.out.println();
        System.out.println("Average price in Stationery category: " + inventoryItemRepository.findAveragePriceByCategory("Stationery"));
        System.out.println();
        System.out.println("Top 3 expensive items: ");
        inventoryItemRepository.findTop3ExpensiveItems().forEach(System.out::println);
    }

}
