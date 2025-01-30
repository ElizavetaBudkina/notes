package org.example.notes.service;

import org.example.notes.domain.dto.request.UserRequestDto;

public interface UserService {

    void save(UserRequestDto userRequestDto);

}
