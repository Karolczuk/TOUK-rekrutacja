package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.MyException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto add(UserDto userDto) {

        if (userDto == null) {
            throw new MyException("User is null");
        }
        User user = Mapper.fromUserDtoToUser(userDto);
        user.setUsername(userDto.getUsername());
        user.setId(Long.valueOf(5678));
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());

        return Mapper.fromUserToUserDto(userRepository.save(user));
    }
}
