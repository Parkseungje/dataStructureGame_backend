package com.datastructuregame.backend.controller.replayController;

import com.datastructuregame.backend.entity.RunStep;
import com.datastructuregame.backend.service.runService.RunService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/replay")
public class ReplayController {
    private final RunService runService;

    @GetMapping("/{runId}/steps")
    public List<RunStep> steps(@PathVariable String runId) {
        return runService.getSteps(UUID.fromString(runId));
    }
}
