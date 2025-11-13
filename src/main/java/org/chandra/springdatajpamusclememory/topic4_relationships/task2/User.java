package org.chandra.springdatajpamusclememory.topic4_relationships.task2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private UserProfile userProfile;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", userProfile=" +
                (userProfile != null
                        ? "{id=" + userProfile.getId() +
                        ", fullName='" + userProfile.getFullName() + '\'' +
                        ", phoneNumber='" + userProfile.getPhoneNumber() + '\'' +
                        ", address='" + userProfile.getAddress() + "'}"
                        : "null") +
                '}';
    }

}
