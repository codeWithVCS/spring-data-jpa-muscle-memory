package org.chandra.springdatajpamusclememory.topic4_relationships.task2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_profiles")
@NoArgsConstructor
@Getter
@Setter
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long id;

    private String fullName;
    private String phoneNumber;
    private String address;

    public UserProfile(String fullName, String phoneNumber, String address) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserProfile{id= " + id + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", address=" + address + '}';
    }
}
