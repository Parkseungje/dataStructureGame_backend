package com.datastructuregame.backend.controller.runController;

import com.datastructuregame.backend.dto.CreateRunRequest;
import com.datastructuregame.backend.service.runService.RunService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/runs")
public class RunController {
    private final RunService runService;

    @PostMapping
    public Map<String,Object> create(@RequestBody CreateRunRequest req) {
        // TODO: 실제는 인증된 사용자 ID 사용
        UUID userId = UUID.randomUUID(); // 임시
        UUID runId = runService.createRun(userId, req.lang(), req.structure(), req.input());
        return Map.of("runId", runId.toString(), "status", "RUNNING");
    }
}

