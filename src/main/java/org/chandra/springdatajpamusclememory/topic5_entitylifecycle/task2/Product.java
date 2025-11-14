package org.chandra.springdatajpamusclememory.topic5_entitylifecycle.task2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @PrePersist
    public void prePersist() {
        this.status = "NEW";
        this.createdAt = LocalDateTime.now();
        System.out.println("[PrePersist] Product is being persisted → status set to NEW");
    }

    @PostPersist
    public void postPersist() {
        System.out.println("[PostPersist] Product persisted with ID: " + this.id);
    }

    @PostLoad
    public void postLoad() {
        System.out.println("[PostLoad] Product loaded from DB: " + this);
    }

    @PreUpdate
    public void preUpdate() {
        this.status = "UPDATED";
        this.updatedAt = LocalDateTime.now();
        System.out.println("[PreUpdate] Product is being updated → status set to UPDATED");
    }

    @PostUpdate
    public void postUpdate() {
        System.out.println("[PostUpdate] Product updated successfully.");
    }

    @PreRemove
    public void preRemove() {
        this.status = "DELETED";
        System.out.println("[PreRemove] Product is being deleted.");
    }

    @PostRemove
    public void postRemove() {
        System.out.println("[PostRemove] Product deleted successfully.");
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
