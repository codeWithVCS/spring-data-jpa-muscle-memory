package org.chandra.springdatajpamusclememory.topic5_entitylifecycle.task3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityListenerRunner implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerEntityListenerRunner(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("==================================================");
        System.out.println("🧩 DEMO: External Entity Listener Lifecycle Flow");
        System.out.println("==================================================");

        // STEP 1: Persist a new Customer  → triggers @PrePersist + @PostPersist
        System.out.println("\n--- STEP 1: Persisting a new customer ---");
        Customer customer = new Customer("Chandra", "chandra@corp.com");
        customerRepository.save(customer);
        System.out.println("✅ Customer saved to database.");

        // STEP 2: Update existing Customer  → triggers @PreUpdate
        System.out.println("\n--- STEP 2: Updating customer name ---");
        customer.setName("Chandra Sekhar");
        customerRepository.save(customer);
        System.out.println("✅ Customer updated successfully.");

        // STEP 3: Retrieve customer from DB  → triggers @PostLoad
        System.out.println("\n--- STEP 3: Fetching customer from database ---");
        Customer fetched = customerRepository.findById(customer.getId()).orElseThrow();
        System.out.println("✅ Customer retrieved: " + fetched);

        // STEP 4: Delete customer  → triggers @PreRemove + @PostRemove
        System.out.println("\n--- STEP 4: Deleting customer record ---");
        customerRepository.delete(fetched);
        System.out.println("✅ Customer deletion completed.");

        System.out.println("\n==================================================");
        System.out.println("✅ ENTITY LIFECYCLE DEMONSTRATION COMPLETE");
        System.out.println("==================================================");
    }
}
