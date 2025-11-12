package org.chandra.springdatajpamusclememory.topic3_customqueries.task7;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_accounts")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String email;
    private String role;
    private boolean active;

    public UserAccount(String userName, String email, String role, boolean active) {
        this.userName = userName;
        this.email = email;
        this.role = role;
        this.active = active;
    }
}
