package org.chandra.springdatajpamusclememory.topic2_entitymapping.task6;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "product_field_access")
@Access(AccessType.FIELD)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductFieldAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(precision = 10)
    private double price;

    @Transient
    private double discount;

    public ProductFieldAccess(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
