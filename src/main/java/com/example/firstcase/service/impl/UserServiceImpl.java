package com.example.firstcase.service.impl;

import com.example.firstcase.data.UserRepository;
import com.example.firstcase.exception.UserAlreadyExist;
import com.example.firstcase.model.dto.UserDTO;
import com.example.firstcase.model.entity.User;
import com.example.firstcase.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        if(userRepository.existsByEmail(userDTO.getEmail())){
            throw new UserAlreadyExist("user already exist with given email");
        }
        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        userRepository.saveAndFlush(user);
        userDTO.setId(user.getId());
        return userDTO;
    }
}
