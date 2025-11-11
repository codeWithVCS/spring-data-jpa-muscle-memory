package org.chandra.springdatajpamusclememory.topic1_intro.task3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataRunner implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerDataRunner(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        customerRepository.findAll().forEach(System.out::println);
    }
}
