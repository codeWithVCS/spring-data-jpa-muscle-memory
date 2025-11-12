package org.chandra.springdatajpamusclememory.topic3_customqueries.task9;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "product_inventory")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private double price;
    private int stock;
    private String supplier;

    public ProductInventory(String name, String category, double price, int stock, String supplier) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.supplier = supplier;
    }
}
