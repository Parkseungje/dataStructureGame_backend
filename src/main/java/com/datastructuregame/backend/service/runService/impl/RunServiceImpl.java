package com.datastructuregame.backend.service.runService.impl;

import com.datastructuregame.backend.entity.Run;
import com.datastructuregame.backend.entity.RunStep;
import com.datastructuregame.backend.repository.RunRepository;
import com.datastructuregame.backend.repository.RunStepRepository;
import com.datastructuregame.backend.service.runService.RunService;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RunServiceImpl implements RunService {

    private final RunRepository runRepo;
    private final RunStepRepository stepRepo;

    @Override
    @Transactional
    public UUID createRun(UUID userId, String lang, String structure, Map<String, Object> input) {
        Run r = new Run();
        r.setUserId(userId);
        r.setLang(lang);
        r.setStructure(structure);
        r.setInputPayload(input);
        r.setStatus("RUNNING");
        runRepo.save(r);
        return r.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<RunStep> getSteps(UUID runId) {
        return stepRepo.findByRunIdOrderByStepOrderAsc(runId);
    }
}
