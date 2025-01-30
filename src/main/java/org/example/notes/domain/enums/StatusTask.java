package org.example.notes.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusTask {
    TO_DO("В ожидании"),
    IN_PROGRESS("В процессе"),
    DONE("Выполнено");

    private final String description;
}
