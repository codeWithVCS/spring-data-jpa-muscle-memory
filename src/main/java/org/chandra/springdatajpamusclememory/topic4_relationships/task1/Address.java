package org.chandra.springdatajpamusclememory.topic4_relationships.task1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "addresses")
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "userProfile")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long id;
    private String street;
    private String city;
    private String zipCode;
    @OneToOne(mappedBy = "address")
    private UserProfile userProfile;

    public Address(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
}
