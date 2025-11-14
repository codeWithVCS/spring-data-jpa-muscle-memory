package org.chandra.springdatajpamusclememory.topic5_entitylifecycle.task4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AuditCustomerRunner implements CommandLineRunner {

    private final AuditCustomerRepository auditCustomerRepository;

    @Autowired
    public AuditCustomerRunner(AuditCustomerRepository auditCustomerRepository) {
        this.auditCustomerRepository = auditCustomerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("==================================================");
        System.out.println("🧩 DEMO: Spring Data JPA Auditing (@CreatedDate, @LastModifiedDate)");
        System.out.println("==================================================");

        // STEP 1: Create new customer
        System.out.println("\n--- STEP 1: Saving new AuditCustomer ---");
        AuditCustomer auditCustomer = new AuditCustomer("Chandra", "chandra@corp.com");
        auditCustomerRepository.save(auditCustomer);
        System.out.println("✅ Customer persisted: " + auditCustomer);

        Thread.sleep(1500); // to differentiate timestamps

        // STEP 2: Update same customer
        System.out.println("\n--- STEP 2: Updating existing AuditCustomer ---");
        auditCustomer.setName("Chandra Sekhar");
        auditCustomerRepository.save(auditCustomer);
        System.out.println("✅ Customer updated successfully.");

        // STEP 3: Fetch and display to verify timestamps
        System.out.println("\n--- STEP 3: Fetching from DB to verify timestamps ---");
        auditCustomerRepository.findAll().forEach(System.out::println);

        System.out.println("\n==================================================");
        System.out.println("✅ AUDITING DEMONSTRATION COMPLETE");
        System.out.println("==================================================");
    }
}
