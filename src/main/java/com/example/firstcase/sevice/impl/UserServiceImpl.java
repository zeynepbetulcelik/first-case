package com.example.firstcase.sevice.impl;

import com.example.firstcase.data.UserRepository;
import com.example.firstcase.model.dto.UserDTO;
import com.example.firstcase.model.entity.User;
import com.example.firstcase.sevice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
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
