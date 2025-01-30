package org.example.notes.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.notes.domain.enums.PriorityTask;
import org.example.notes.domain.enums.StatusTask;

import java.util.UUID;

public record TaskRequestDto(

    @NotBlank
    String header,
    @NotBlank
    String description,
    @NotNull
    StatusTask status,
    @NotNull
    PriorityTask priority,
    @NotNull
    UUID reporterId,
    @NotNull
    UUID assigneeId
) { }
