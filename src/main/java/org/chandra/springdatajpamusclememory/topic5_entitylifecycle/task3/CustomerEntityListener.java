package org.chandra.springdatajpamusclememory.topic5_entitylifecycle.task3;

import jakarta.persistence.*;
import java.time.LocalDateTime;

public class CustomerEntityListener {

    @PrePersist
    public void prePersist(Customer customer) {
        customer.setCreatedAt(LocalDateTime.now());
        System.out.println("[CustomerEntityListener] PrePersist → Setting createdAt timestamp");
    }

    @PostPersist
    public void postPersist(Customer customer) {
        System.out.println("[CustomerEntityListener] PostPersist → Customer persisted successfully");
    }

    @PreUpdate
    public void preUpdate(Customer customer) {
        customer.setUpdatedAt(LocalDateTime.now());
        System.out.println("[CustomerEntityListener] PreUpdate → Updating updatedAt timestamp");
    }

    @PostLoad
    public void postLoad(Customer customer) {
        System.out.println("[CustomerEntityListener] PostLoad → Customer fetched from DB");
    }

    @PreRemove
    public void preRemove(Customer customer) {
        System.out.println("[CustomerEntityListener] PreRemove → Deletion initialized");
    }

    @PostRemove
    public void postRemove(Customer customer) {
        System.out.println("[CustomerEntityListener] PostRemove → Customer removal complete");
    }
}
