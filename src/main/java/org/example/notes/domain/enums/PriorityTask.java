package org.example.notes.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PriorityTask {
    HIGH("Высокий"),
    MEDIUM("Средний"),
    LOW("Низкий");

    private final String description;
}
