package org.example.notes.service;

import org.example.notes.domain.dto.request.TaskRequestDto;
import org.example.notes.domain.dto.response.TaskResponseDto;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    void save(TaskRequestDto taskRequestDto);

    void delete(UUID id);

    List<TaskResponseDto> findAll();

    TaskResponseDto findById(UUID id);

}
