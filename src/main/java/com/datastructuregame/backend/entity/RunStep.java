package com.datastructuregame.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.OffsetDateTime;
import java.util.Map;

@Entity @Table(name = "run_steps")
@Getter @Setter @NoArgsConstructor
public class RunStep {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="run_id", columnDefinition="uuid", nullable=false)
    private java.util.UUID runId;

    @Column(name="step_order", nullable=false)
    private Integer stepOrder;

    private Integer line;

    @Column(name="step_type", nullable=false)
    private String stepType;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition="jsonb", nullable=false)
    private Map<String,Object> payload;

    @Column(name="created_at", nullable=false)
    private OffsetDateTime createdAt = OffsetDateTime.now();
}
