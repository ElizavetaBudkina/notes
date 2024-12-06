package org.example.notes.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.notes.domain.entity.User;
import org.example.notes.domain.enums.PriorityTask;
import org.example.notes.domain.enums.StatusTask;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskRequestDto(

    @NotNull
    UUID id,
    @NotBlank
    String header,
    @NotBlank
    String description,
    @NotNull
    StatusTask status,
    @NotNull
    PriorityTask priority,
    @NotNull
    UUID reporter,
    @NotNull
    UUID assignee,
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    LocalDateTime dateTime
) { }
