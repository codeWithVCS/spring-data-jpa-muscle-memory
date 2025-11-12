package org.chandra.springdatajpamusclememory.topic3_customqueries.task10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerProfileRunner implements CommandLineRunner {

    private final CustomerProfileRepository customerProfileRepository;

    @Autowired
    public CustomerProfileRunner(CustomerProfileRepository customerProfileRepository) {
        this.customerProfileRepository = customerProfileRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        customerProfileRepository.save(new CustomerProfile("Chandra", "chandra@mail.com", "Hyderabad", 120));
        customerProfileRepository.save(new CustomerProfile("Daniel", "daniel@mail.com", "Chennai", 80));
        customerProfileRepository.save(new CustomerProfile("Asha", "asha@mail.com", "Hyderabad", 200));
        customerProfileRepository.save(new CustomerProfile("Neha", "neha@mail.com", "Bangalore", 150));
        customerProfileRepository.save(new CustomerProfile("Ravi", "ravi@mail.com", "Pune", 50));
        customerProfileRepository.save(new CustomerProfile("Divya", "divya@mail.com", "Chennai", 110));
        customerProfileRepository.save(new CustomerProfile("Kiran", "kiran@mail.com", "Hyderabad", 90));

        System.out.println("Customers from city = 'Hyderabad': ");
        customerProfileRepository.findByCity("Hyderabad").forEach(System.out::println);

        System.out.println();

        System.out.println("Customers with loyalty points >= 100: ");
        customerProfileRepository.findByLoyaltyPoints(100).forEach(System.out::println);
    }
}
