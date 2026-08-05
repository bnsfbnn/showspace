package com.ntq.showspace.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EntityListeners(AuditListener.class)
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "last_modified_at")
    private Instant lastModifiedAt;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}
