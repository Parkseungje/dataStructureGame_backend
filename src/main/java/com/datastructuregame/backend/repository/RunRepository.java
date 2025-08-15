package com.datastructuregame.backend.repository;

import com.datastructuregame.backend.entity.Run;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunRepository extends JpaRepository<Run, UUID> {

}
