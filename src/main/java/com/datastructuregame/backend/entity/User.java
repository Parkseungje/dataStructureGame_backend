package com.datastructuregame.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity @Table(name = "users")
@Getter @Setter @NoArgsConstructor
public class User {
    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @PrePersist
    public void pre() { if (id == null) id = UUID.randomUUID(); }

    @Column(nullable=false, unique=true)
    private String email;

    @Column(name="password_hash", nullable=false)
    private String passwordHash;

    @Column(nullable=false)
    private String role = "STUDENT";

    @Column(name="created_at", nullable=false)
    private OffsetDateTime createdAt = OffsetDateTime.now();
}
