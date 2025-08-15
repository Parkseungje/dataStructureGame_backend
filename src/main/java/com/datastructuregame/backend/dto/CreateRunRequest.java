package com.datastructuregame.backend.dto;

import java.util.Map;

public record CreateRunRequest(
    String lang,
    String structure,
    Map<String,Object> input
) {

}
