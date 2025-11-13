package org.chandra.springdatajpamusclememory.topic4_relationships.task1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_profiles")
@NoArgsConstructor
@Getter
@Setter
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public  UserProfile(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserProfile{id=" + id + ", name='" + name + "', email='" + email +
                "', addressCity=" + (address != null ? address.getCity() : "null") + '}';
    }
}
