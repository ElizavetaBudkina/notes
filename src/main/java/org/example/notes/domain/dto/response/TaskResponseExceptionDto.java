package org.example.notes.domain.dto.response;

import lombok.Builder;

@Builder
public record TaskResponseExceptionDto(
    String message
) { }
