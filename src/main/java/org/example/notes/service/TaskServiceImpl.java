package org.example.notes.service;

import lombok.RequiredArgsConstructor;
import org.example.notes.domain.dto.TasksRequestDto;
import org.example.notes.domain.dto.TasksResponseDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TasksServiceImpl implements TasksService {

    public void save(TasksRequestDto tasksRequestDto){

    }

    public void update(TasksRequestDto tasksRequestDto){

    }

    public void delete(TasksRequestDto tasksRequestDto){

    }

    public void updateByStatus(TasksRequestDto tasksRequestDto){

    }

    public void updateByAssignee(TasksRequestDto tasksRequestDto){

    }

    public TasksResponseDto findAll(){
        return null;
    }

    public TasksResponseDto findById(UUID id){
        return null;
    }

}
