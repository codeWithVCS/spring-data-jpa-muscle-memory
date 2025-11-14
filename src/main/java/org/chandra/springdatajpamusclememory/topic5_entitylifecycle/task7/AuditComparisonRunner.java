package org.chandra.springdatajpamusclememory.topic5_entitylifecycle.task7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AuditComparisonRunner implements CommandLineRunner {

    private final CallbackAuditRepository callbackAuditRepository;
    private final SpringAuditRepository springAuditRepository;

    @Autowired
    public AuditComparisonRunner(CallbackAuditRepository callbackAuditRepository, SpringAuditRepository springAuditRepository) {
        this.callbackAuditRepository = callbackAuditRepository;
        this.springAuditRepository = springAuditRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("==================================================");
        System.out.println("🧩 DEMO: Entity Callback vs Spring Data Auditing");
        System.out.println("==================================================");

        System.out.println("\n--- STEP 1: Saving new entities ---");
        CallbackAuditEntity callbackEntity = new CallbackAuditEntity("CallbackEntity");
        SpringAuditEntity springEntity = new SpringAuditEntity("SpringEntity");
        callbackAuditRepository.save(callbackEntity);
        springAuditRepository.save(springEntity);

        Thread.sleep(1000); // delay to separate timestamps

        System.out.println("\n--- STEP 2: Updating both entities ---");
        callbackEntity.setName("CallbackEntity-Updated");
        springEntity.setName("SpringEntity-Updated");
        callbackAuditRepository.save(callbackEntity);
        springAuditRepository.save(springEntity);

        System.out.println("\n--- STEP 3: Fetching results ---");
        System.out.println("Callback Audit Entity: ");
        callbackAuditRepository.findAll().forEach(System.out::println);
        System.out.println("\nSpring Audit Entity: ");
        springAuditRepository.findAll().forEach(System.out::println);

        System.out.println("\n==================================================");
        System.out.println("✅ COMPARISON COMPLETE");
        System.out.println("==================================================");
    }
}
