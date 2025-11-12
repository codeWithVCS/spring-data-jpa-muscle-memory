package org.chandra.springdatajpamusclememory.topic3_customqueries.task10;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer_profiles_named")
@NoArgsConstructor
@Getter
@Setter
@ToString

@NamedQuery(
        name = "CustomerProfile.findByCity",
        query = "SELECT c FROM CustomerProfile c WHERE c.city = :city"
)
@NamedNativeQuery(
        name = "CustomerProfile.findByLoyaltyPoints",
        query = "SELECT * FROM customer_profiles_named WHERE loyalty_points >= :minPoints",
        resultClass = CustomerProfile.class
)
public class CustomerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String city;
    private int loyaltyPoints;

    public CustomerProfile(String name, String email, String city, int loyaltyPoints) {
        this.name = name;
        this.email = email;
        this.city = city;
        this.loyaltyPoints = loyaltyPoints;
    }


}
