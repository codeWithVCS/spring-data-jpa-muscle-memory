package org.chandra.springdatajpamusclememory.topic2_entitymapping.task3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OrderRecordRunner implements CommandLineRunner {
    private final OrderRecordRepository orderRecordRepository;
    @Autowired
    public OrderRecordRunner(OrderRecordRepository orderRecordRepository) {
        this.orderRecordRepository = orderRecordRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        OrderRecord ORD001 = new OrderRecord("ORD-001", 2500.0, "NEW");
        OrderRecord ORD002 = new OrderRecord("ORD-002", 4500.0, "PROCESSING");
        OrderRecord ORD003 = new OrderRecord("ORD-003", 7000.0, "COMPLETED");

        orderRecordRepository.save(ORD001);
        orderRecordRepository.save(ORD002);
        orderRecordRepository.save(ORD003);

        orderRecordRepository.findAll().forEach(System.out::println);
    }
}
