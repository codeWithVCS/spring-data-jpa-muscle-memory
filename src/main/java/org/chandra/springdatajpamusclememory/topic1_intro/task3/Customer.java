package org.chandra.springdatajpamusclememory.topic1_intro.task3;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String city;

    public Customer(String name, String email, String city) {
        this.name = name;
        this.email = email;
        this.city = city;
    }
}
