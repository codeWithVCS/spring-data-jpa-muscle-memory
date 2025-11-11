package org.chandra.springdatajpamusclememory.topic2_entitymapping.task7;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "product_property_access")
@NoArgsConstructor
@ToString
public class ProductPropertyAccess {

    private Long id;
    private String name;
    private double price;
    private double discountedPrice;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {return id;}
    public  void setId(Long id) {this.id = id;}

    @Column(nullable = false, length = 50)
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Column(precision = 10)
    public double getPrice() {return price;}
    public void setPrice(double price) {
        this.price = price;
    }

    @Transient
    public double getDiscountedPrice() {return discountedPrice;}
    public  void setDiscountedPrice() {
        this.discountedPrice = price - (price * 0.10);
    }
    public ProductPropertyAccess(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
