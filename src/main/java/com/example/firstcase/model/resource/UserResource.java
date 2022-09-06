package com.example.firstcase.model.resource;

import com.example.firstcase.model.dto.UserDTO;
import com.example.firstcase.sevice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDTO));
    }


}
