package org.example.notes.mapper;

import org.example.notes.domain.dto.TasksRequestDto;
import org.example.notes.domain.dto.TasksResponseDto;
import org.example.notes.domain.entity.Tasks;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TasksMapper {
    Tasks toEntity(TasksRequestDto tasksRequestDto);

    TasksResponseDto toTasksDto(Tasks tasks);
}
