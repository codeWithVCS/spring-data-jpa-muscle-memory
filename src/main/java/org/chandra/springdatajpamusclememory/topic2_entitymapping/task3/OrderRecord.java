package org.chandra.springdatajpamusclememory.topic2_entitymapping.task3;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "order_records")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderRecord {
    @Id
    @SequenceGenerator(
            name = "order_seq",
            sequenceName = "order_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    private Long id;
    private String orderNumber;
    private double amount;
    private String status;

    public  OrderRecord(String orderNumber, double amount, String status) {
        this.orderNumber = orderNumber;
        this.amount = amount;
        this.status = status;
    }
}
