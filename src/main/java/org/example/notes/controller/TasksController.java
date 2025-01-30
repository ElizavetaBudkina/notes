package org.example.notes.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.notes.domain.dto.request.TaskRequestDto;
import org.example.notes.logging.Loggable;
import org.example.notes.service.TaskService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
@Loggable
@Tag(name = "Tasks Controller",
     description = "Контроллер для создания кредитной задачи, а также " +
         "получения всех задач и одной задачи по заданному id.")
public class TasksController {

    private final TaskService taskService;

    @PostMapping
    @Operation(
        summary = "Создание задачи",
        description = "Позволяет создать новую задачу"
    )
    public ResponseEntity<?> createTask(
        @Parameter(description = "ДТО, в котором находятся требуемые поля для создания задачи", required = true)
        @Validated @RequestBody TaskRequestDto taskRequestDto) {

        taskService.save(taskRequestDto);
        return ResponseEntity.ok().body("Задача создана успешно");
    }
    @GetMapping
    @Operation(
        summary = "Получение всех задач",
        description = "Позволяет получить информацию по всем задачам"
    )
    public ResponseEntity<?> getAllTasks() {

        return ResponseEntity.ok().body(taskService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Получение одной задачи",
        description = "Позволяет получить информацию для одной задачи по ее id"
    )
    public ResponseEntity<?> getTaskById(
        @Parameter(description = "Id задачи", required = true)
        @PathVariable UUID id) {

        return ResponseEntity.ok().body(taskService.findById(id));
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Удаление задачи",
        description = "Позволяет удалить задачу по ее id"
    )
    public ResponseEntity<?> deleteTaskById(
        @Parameter(description = "Id задачи", required = true)
        @PathVariable UUID id){

        taskService.delete(id);
        return ResponseEntity.ok().body("Изменения внесены");
    }

}
