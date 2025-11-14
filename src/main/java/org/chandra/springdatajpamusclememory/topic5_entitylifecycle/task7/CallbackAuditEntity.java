package org.chandra.springdatajpamusclememory.topic5_entitylifecycle.task7;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@EntityListeners(CallbackAuditListener.class)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CallbackAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CallbackAuditEntity(String name) {
        this.name = name;
    }
}
