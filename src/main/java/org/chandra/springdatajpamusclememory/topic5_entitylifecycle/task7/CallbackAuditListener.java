package org.chandra.springdatajpamusclememory.topic5_entitylifecycle.task7;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;

public class CallbackAuditListener {

    @PrePersist
    public void prePersist(CallbackAuditEntity entity) {
        entity.setCreatedAt(LocalDateTime.now());
        System.out.println("[CALLBACK] PrePersist triggered → createdAt set");
    }

    @PreUpdate
    public void preUpdate(CallbackAuditEntity entity) {
        entity.setUpdatedAt(LocalDateTime.now());
        System.out.println("[CALLBACK] PreUpdate triggered → updatedAt set");
    }
}
