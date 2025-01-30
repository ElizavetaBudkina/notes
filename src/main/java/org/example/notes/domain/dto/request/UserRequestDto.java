package org.example.notes.domain.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UserRequestDto(

    @NotBlank
    String firstName,
    @NotBlank
    String secondName,
    @NotBlank
    String middleName

) { }
