package org.chandra.springdatajpamusclememory.topic3_customqueries.task6;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment_records")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PaymentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String payerName;
    private double amount;
    private String method;
    private String status;
    private LocalDateTime timeStamp;

    public PaymentRecord(String payerName, double amount, String method, String status, LocalDateTime timeStamp) {
        this.payerName = payerName;
        this.amount = amount;
        this.method = method;
        this.status = status;
        this.timeStamp = timeStamp;
    }
}
