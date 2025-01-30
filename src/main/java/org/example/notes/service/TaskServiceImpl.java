package org.example.notes.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.notes.domain.dto.request.TaskRequestDto;
import org.example.notes.domain.dto.response.TaskResponseDto;
import org.example.notes.domain.entity.Task;
import org.example.notes.domain.entity.User;
import org.example.notes.exceptions.NotFoundException;
import org.example.notes.logging.Loggable;
import org.example.notes.mapper.TaskMapper;
import org.example.notes.repository.TaskRepository;
import org.example.notes.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Loggable
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UserRepository userRepository;

    @Transactional
    public void save(TaskRequestDto taskRequestDto){

        Task task = taskMapper.toEntity(taskRequestDto);
        User reporter = userRepository.findById(taskRequestDto.reporterId())
            .orElseThrow(() -> new NotFoundException("Пользователь с таким id не найден!"));
        User assignee = userRepository.findById(taskRequestDto.assigneeId())
            .orElseThrow(() -> new NotFoundException("Пользователь с таким id не найден!"));
        task.setReporter(reporter);
        task.setAssignee(assignee);
        task.setDateTime(LocalDateTime.now());
        taskRepository.save(task);
    }

    public void delete(UUID id){

        taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Задача с таким id не найдена!"));
        taskRepository.deleteById(id);
    }

    public List<TaskResponseDto> findAll(){

        return taskRepository.findAll().stream()
            .map(taskMapper::toDto).toList();
    }

    public TaskResponseDto findById(UUID id){

        return taskMapper.toDto(taskRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Пользователь с таким id не найден!")));
    }
}
