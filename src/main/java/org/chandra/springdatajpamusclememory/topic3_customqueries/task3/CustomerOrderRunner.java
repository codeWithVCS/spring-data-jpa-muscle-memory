package org.chandra.springdatajpamusclememory.topic3_customqueries.task3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerOrderRunner implements CommandLineRunner {

    private final CustomerOrderRepository customerOrderRepository;

    @Autowired
    public CustomerOrderRunner(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        customerOrderRepository.save(new CustomerOrder("Chandra", "Laptop", 1, 80000.0, "NEW"));
        customerOrderRepository.save(new CustomerOrder("Daniel", "Smartphone", 2, 40000.0, "SHIPPED"));
        customerOrderRepository.save(new CustomerOrder("Asha", "TV", 1, 60000.0, "DELIVERED"));
        customerOrderRepository.save(new CustomerOrder("Ravi", "Refrigerator", 1, 55000.0, "DELIVERED"));
        customerOrderRepository.save(new CustomerOrder("Neha", "Washing Machine", 1, 35000.0, "SHIPPED"));
        customerOrderRepository.save(new CustomerOrder("Kiran", "Headphones", 3, 2000.0, "NEW"));
        customerOrderRepository.save(new CustomerOrder("Divya", "Microwave", 2, 25000.0, "DELIVERED"));
        customerOrderRepository.save(new CustomerOrder("Rahul", "Desk Lamp", 5, 1200.0, "NEW"));

        System.out.println("Orders with status = 'NEW': ");
        customerOrderRepository.findByStatus("NEW").forEach(System.out::println);

        System.out.println("Expensive orders (price > 2000, qty >= 2): ");
        customerOrderRepository.findExpensiveOrder(2000, 2).forEach(System.out::println);

        System.out.println("Delivered orders (Customer + Product): ");
        customerOrderRepository.findDeliveredOrderDetails().forEach(System.out::println);


        System.out.println("Count of SHIPPED orders: " + customerOrderRepository.countByStatus("SHIPPED"));

        System.out.println("Average order value: " + customerOrderRepository.findAverageOrderValue());
    }
}
