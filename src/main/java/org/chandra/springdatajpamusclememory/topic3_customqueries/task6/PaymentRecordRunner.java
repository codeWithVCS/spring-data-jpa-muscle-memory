package org.chandra.springdatajpamusclememory.topic3_customqueries.task6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PaymentRecordRunner implements CommandLineRunner {

    private final PaymentRecordRepository paymentRecordRepository;

    @Autowired
    public PaymentRecordRunner(PaymentRecordRepository paymentRecordRepository) {
        this.paymentRecordRepository = paymentRecordRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        paymentRecordRepository.save(new PaymentRecord("Chandra", 85000.0, "CARD", "SUCCESS", LocalDateTime.now()));
        paymentRecordRepository.save(new PaymentRecord("Asha", 15000.0, "UPI", "PENDING", LocalDateTime.now()));
        paymentRecordRepository.save(new PaymentRecord("Daniel", 10000.0, "CASH", "FAILED", LocalDateTime.now()));
        paymentRecordRepository.save(new PaymentRecord("Ravi", 45000.0, "UPI", "SUCCESS", LocalDateTime.now()));
        paymentRecordRepository.save(new PaymentRecord("Kiran", 2000.0, "CARD", "FAILED", LocalDateTime.now()));
        paymentRecordRepository.save(new PaymentRecord("Divya", 65000.0, "UPI", "SUCCESS", LocalDateTime.now()));
        paymentRecordRepository.save(new PaymentRecord("Neha", 5000.0, "CASH", "SUCCESS", LocalDateTime.now()));
        paymentRecordRepository.save(new PaymentRecord("Vikas", 12000.0, "CARD", "SUCCESS", LocalDateTime.now()));

        PaymentRecord testRecord = new PaymentRecord(null, 0, "CARD", "SUCCESS", null);

        System.out.println("Payments matching method='CARD' and status='SUCCESS': ");
        paymentRecordRepository.findRecordsByMatchingMethodAndStatus(testRecord).forEach(System.out::println);
        System.out.println();
        System.out.println("Payments above threshold 20000: ");
        paymentRecordRepository.findByAmountGreaterThanOrEqual(20000).forEach(System.out::println);
        System.out.println();
        System.out.println("Count of successful UPI payments: " + paymentRecordRepository.countByMethodAndSuccess("UPI"));
    }
}
