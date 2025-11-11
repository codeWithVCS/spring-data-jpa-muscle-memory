package org.chandra.springdatajpamusclememory.topic2_entitymapping.task4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerProfileRunner implements CommandLineRunner {

    private CustomerProfileRepository customerProfileRepository;

    @Autowired
    public  CustomerProfileRunner(CustomerProfileRepository customerProfileRepository) {
        this.customerProfileRepository = customerProfileRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        CustomerProfile cp1 = new CustomerProfile("Chandra Sekhar", "chandra@corp.com", "98765432100", 50000.0, "ACTIVE");
        CustomerProfile cp2 = new CustomerProfile("Daniel Victor", "daniel@corp.com", "9123456789", 30000.00, "PREMIUM");
        CustomerProfile cp3 = new CustomerProfile("Asha Rao", "asha@corp.com", "9876512345", 20000.00, "INACTIVE");

        customerProfileRepository.save(cp1);
        customerProfileRepository.save(cp2);
        customerProfileRepository.save(cp3);

        customerProfileRepository.findAll().forEach(System.out::println);
    }
}
