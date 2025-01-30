package org.example.notes.service;

import lombok.RequiredArgsConstructor;
import org.example.notes.domain.dto.request.UserRequestDto;
import org.example.notes.domain.entity.User;
import org.example.notes.mapper.UserMapper;
import org.example.notes.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void save(UserRequestDto userRequestDto) {

        User user = userMapper.toEntity(userRequestDto);
        userRepository.save(user);
    }
}
