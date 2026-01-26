package com.ntq.showspace.entity.base;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.Instant;

public class AuditListener {

    @PrePersist
    public void onPrePersist(Object entity) {
        if (entity instanceof BaseEntity) {
            BaseEntity base = (BaseEntity) entity;
            Instant now = Instant.now();

            base.setCreatedAt(now);
            base.setLastModifiedAt(now);
        }
    }

    @PreUpdate
    public void onPreUpdate(Object entity) {
        if (entity instanceof BaseEntity) {
            BaseEntity base = (BaseEntity) entity;

            base.setLastModifiedAt(Instant.now());
        }
    }
}
