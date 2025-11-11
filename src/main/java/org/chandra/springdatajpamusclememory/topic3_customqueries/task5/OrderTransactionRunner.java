package org.chandra.springdatajpamusclememory.topic3_customqueries.task5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OrderTransactionRunner implements CommandLineRunner {

    private final OrderTransactionRepository orderTransactionRepository;

    @Autowired
    public OrderTransactionRunner(OrderTransactionRepository orderTransactionRepository) {
        this.orderTransactionRepository = orderTransactionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        orderTransactionRepository.save(new OrderTransaction("ORD-1001", "Chandra", 85000.0, "CARD", "PAID"));
        orderTransactionRepository.save(new OrderTransaction("ORD-1002", "Asha", 45000.0, "UPI", "PENDING"));
        orderTransactionRepository.save(new OrderTransaction("ORD-1003", "Daniel", 12000.0, "CASH", "CANCELLED"));
        orderTransactionRepository.save(new OrderTransaction("ORD-1004", "Chandra", 30000.0, "UPI", "PENDING"));
        orderTransactionRepository.save(new OrderTransaction("ORD-1005", "Ravi", 25000.0, "CARD", "PAID"));
        orderTransactionRepository.save(new OrderTransaction("ORD-1006", "Neha", 10000.0, "CASH", "PAID"));
        orderTransactionRepository.save(new OrderTransaction("ORD-1007", "Kiran", 65000.0, "CARD", "PAID"));
        orderTransactionRepository.save(new OrderTransaction("ORD-1008", "Asha", 22000.0, "UPI", "CANCELLED"));
        orderTransactionRepository.save(new OrderTransaction("ORD-1009", "Divya", 70000.0, "UPI", "PAID"));

        System.out.println("Transactions for customer = 'Chandra' and status = 'PAID': ");
        orderTransactionRepository.findByCustomerAndStatus("Chandra", "PAID").forEach(System.out::println);
        System.out.println();
        System.out.println("Transactions with total amount >= 20000: ");
        orderTransactionRepository.findByAmountGreaterThanEqual(20000).forEach(System.out::println);
        System.out.println();
        System.out.println("Count of transactions made via CARD: " +orderTransactionRepository.countTransactionsByPaymentMethod("CARD"));
    }
}
