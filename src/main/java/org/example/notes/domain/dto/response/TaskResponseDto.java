package org.example.notes.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.example.notes.domain.entity.User;
import org.example.notes.domain.enums.PriorityTask;
import org.example.notes.domain.enums.StatusTask;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskResponseDto(

    UUID id,
    String header,
    String description,
    StatusTask status,
    PriorityTask priority,
    UserForTaskResponseDto reporter,
    UserForTaskResponseDto assignee,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    LocalDateTime dateTime
) { }
