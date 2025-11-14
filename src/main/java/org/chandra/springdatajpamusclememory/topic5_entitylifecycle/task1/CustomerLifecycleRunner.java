package org.chandra.springdatajpamusclememory.topic5_entitylifecycle.task1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerLifecycleRunner implements CommandLineRunner {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Customer customer = new Customer("Chandra", "chandra@corp.com");
        System.out.println("Customer created -> Transient: " + customer);

        em.persist(customer);
        System.out.println("Customer Persisted -> Persistent: " + customer);

        em.detach(customer);
        System.out.println("Customer Detached -> Detached: " + customer);

        customer.setName("Chandra Sekhar");
        customer = em.merge(customer);
        System.out.println("Customer merged -> Persistent again:  " + customer);

        em.remove(customer);
        System.out.println("Customer removed -> Removed: " + customer);
    }
}
