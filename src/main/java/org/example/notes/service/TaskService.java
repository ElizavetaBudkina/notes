package org.example.notes.service;

import org.example.notes.domain.dto.TasksRequestDto;
import org.example.notes.domain.dto.TasksResponseDto;

import java.util.UUID;

public interface TasksService {

    void save(TasksRequestDto tasksRequestDto);

    void update(TasksRequestDto tasksRequestDto);

    void delete(TasksRequestDto tasksRequestDto);

    void updateByStatus(TasksRequestDto tasksRequestDto);

    void updateByAssignee(TasksRequestDto tasksRequestDto);

    TasksResponseDto findAll();

    TasksResponseDto findById(UUID id);

}
