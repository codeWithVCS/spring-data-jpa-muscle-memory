package org.chandra.springdatajpamusclememory.topic3_customqueries.task2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "product_records")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String category;
    private double price;
    private boolean available;

    public  ProductRecord(String name, String category, double price, boolean available) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.available = available;
    }
}
