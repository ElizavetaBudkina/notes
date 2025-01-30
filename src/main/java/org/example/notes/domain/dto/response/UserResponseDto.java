package org.example.notes.domain.dto.response;

import java.util.UUID;

public record UserResponseDto(

    UUID id,
    String firstName,
    String secondName,
    String middleName
) { }
