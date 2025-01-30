package org.example.notes.controller.handler;

import lombok.extern.slf4j.Slf4j;
import org.example.notes.domain.dto.response.TaskResponseExceptionDto;
import org.example.notes.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> catchNotFoundException(NotFoundException ex) {
        TaskResponseExceptionDto exceptionDto = TaskResponseExceptionDto.builder().message(ex.getMessage()).build();
        log.error("NotFoundException handling. StackTrace:", ex);
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

}
