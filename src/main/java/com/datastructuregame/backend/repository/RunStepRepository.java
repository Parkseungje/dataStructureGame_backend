package com.datastructuregame.backend.repository;

import com.datastructuregame.backend.entity.RunStep;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunStepRepository extends JpaRepository<RunStep, Long> {
    List<RunStep> findByRunIdOrderByStepOrderAsc(java.util.UUID runId);
}
