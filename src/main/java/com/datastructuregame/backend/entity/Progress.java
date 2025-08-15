package com.datastructuregame.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Entity @Table(name="progress",
        uniqueConstraints=@UniqueConstraint(columnNames={"user_id","world","level"}))
@Getter @Setter @NoArgsConstructor
public class Progress {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id", columnDefinition="uuid", nullable=false)
    private java.util.UUID userId;

    @Column(nullable=false) private String world;
    @Column(nullable=false) private Integer level;
    @Column(nullable=false) private Integer score = 0;

    @Column(name="cleared_at", nullable=false)
    private OffsetDateTime clearedAt = OffsetDateTime.now();
}
