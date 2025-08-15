package com.datastructuregame.backend.dto;

import java.util.Map;

public record RunEventMessage(
    String runId,
    String step,         // call/assign/render/return/error
    String func,
    Integer line,
    Map<String,Object> state,
    String message,
    Object value
) {}
