package org.chandra.springdatajpamusclememory.topic3_customqueries.task5;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "order_transactions")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderId;
    private String customerName;
    private double amount;
    private String paymentMethod;
    private String status;

    public OrderTransaction(String orderId, String customerName, double amount, String paymentMethod, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }
}
