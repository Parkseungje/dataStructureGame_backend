package com.datastructuregame.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

@Entity @Table(name = "runs")
@Getter @Setter @NoArgsConstructor
public class Run {
    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @PrePersist public void pre(){ if (id==null) id = UUID.randomUUID(); }

    @Column(name="user_id", columnDefinition="uuid", nullable=false)
    private UUID userId;

    @Column(nullable=false) private String lang;       // java/python/...
    @Column(nullable=false) private String structure;  // stack/queue/...

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name="input_payload", columnDefinition="jsonb", nullable=false)
    private Map<String,Object> inputPayload;

    @Column(nullable=false) private String status;     // RUNNING/DONE/ERROR

    @Column(name="started_at", nullable=false)
    private OffsetDateTime startedAt = OffsetDateTime.now();

    @Column(name="finished_at")
    private OffsetDateTime finishedAt;
}
