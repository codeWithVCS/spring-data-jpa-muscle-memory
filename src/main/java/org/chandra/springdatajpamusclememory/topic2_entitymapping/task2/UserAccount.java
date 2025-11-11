package org.chandra.springdatajpamusclememory.topic2_entitymapping.task2;

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
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String username;
    private String email;
    private String role;

    public  UserAccount(String username, String email, String role) {
        this.username = username;
        this.email = email;
        this.role = role;
    }
}
