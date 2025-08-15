package com.datastructuregame.backend.repository;

import com.datastructuregame.backend.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressRepository extends JpaRepository<Progress, Long> {

}
