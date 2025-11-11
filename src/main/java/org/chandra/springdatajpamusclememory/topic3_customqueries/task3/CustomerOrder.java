package org.chandra.springdatajpamusclememory.topic3_customqueries.task3;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer_orders")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String productName;
    private int quantity;
    private double pricePerUnit;
    private String status;

    public CustomerOrder(String customerName, String productName, int quantity, double pricePerUnit, String status) {
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.status = status;
    }
}
