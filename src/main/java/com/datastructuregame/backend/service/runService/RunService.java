package com.datastructuregame.backend.service.runService;

import com.datastructuregame.backend.entity.RunStep;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface RunService {
    UUID createRun(UUID userId, String lang, String structure, Map<String, Object> input);
    List<RunStep> getSteps(UUID runId);
}
