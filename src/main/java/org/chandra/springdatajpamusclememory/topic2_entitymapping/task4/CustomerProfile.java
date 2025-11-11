package org.chandra.springdatajpamusclememory.topic2_entitymapping.task4;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer_profiles")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name",  nullable = false, length = 100)
    private String fullName;

    @Column(unique = true, nullable = false, length = 150)
    private String email;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @Column(name = "credit_limit", precision = 10)
    private double creditLimit;

    @Column(nullable = false,  length = 20)
    private String status;

    public CustomerProfile(String fullName, String email, String phoneNumber, double creditLimit, String status) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.creditLimit = creditLimit;
        this.status = status;
    }
}
