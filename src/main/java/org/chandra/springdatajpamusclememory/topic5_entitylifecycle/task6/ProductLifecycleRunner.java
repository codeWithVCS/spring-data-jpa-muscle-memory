package org.chandra.springdatajpamusclememory.topic5_entitylifecycle.task6;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductLifecycleRunner implements CommandLineRunner {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("==================================================");
        System.out.println("🧩 DEMO: JPA ENTITY LIFECYCLE STATES");
        System.out.println("==================================================");

        // STEP 1: Transient
        System.out.println("\n--- STEP 1: TRANSIENT ---");
        ProductLifecycle productLifecycle = new ProductLifecycle("Laptop", "Electronics", 85000.0);
        System.out.println(productLifecycle);
        System.out.println("State: TRANSIENT – Not yet managed by Persistence Context");

        // STEP 2: Persistent
        System.out.println("\n--- STEP 2: PERSIST ---");
        em.persist(productLifecycle);
        em.flush(); // forces insert
        System.out.println("✅ Product persisted with ID = " + productLifecycle.getId());
        System.out.println("State: PERSISTENT – Managed by Persistence Context");

        // STEP 3: Detach
        System.out.println("\n--- STEP 3: DETACH ---");
        em.detach(productLifecycle);
        System.out.println("✅ Entity detached from Persistence Context");
        productLifecycle.setPrice(90000.0);
        System.out.println("Detached entity modified (price updated to " + productLifecycle.getPrice() + ")");
        System.out.println("State: DETACHED – Changes not tracked");

        // STEP 4: Merge
        System.out.println("\n--- STEP 4: MERGE ---");
        ProductLifecycle mergedEntity = em.merge(productLifecycle);
        em.flush(); // sync merge
        System.out.println("✅ Detached entity merged and updated in DB: " + mergedEntity);
        System.out.println("State: MANAGED again after merge");

        // STEP 5: Remove
        System.out.println("\n--- STEP 5: REMOVE ---");
        ProductLifecycle toDelete = em.find(ProductLifecycle.class, mergedEntity.getId());
        em.remove(toDelete);
        em.flush();
        System.out.println("✅ Entity removed from DB");
        System.out.println("State: REMOVED – Deletion complete");

        System.out.println("\n==================================================");
        System.out.println("✅ LIFECYCLE DEMONSTRATION COMPLETE");
        System.out.println("==================================================");
    }
}
