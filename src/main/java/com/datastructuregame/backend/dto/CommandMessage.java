package com.datastructuregame.backend.dto;

public record CommandMessage(
    String op,
    Integer index,
    Object value
) {

}
