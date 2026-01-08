package com.schedule2.user.controller;

import com.schedule2.schedule.dto.*;
import com.schedule2.user.dto.*;
import com.schedule2.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserCreateResponse> createUser(
           @Valid @RequestBody UserCreateRequest request
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(request));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserGetResponse>> getUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserGetResponse> getUser(
            @PathVariable Long userId
    ){
        return ResponseEntity.ok(userService.findOne(userId));
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<UserUpdateResponse> updateUser(
            @PathVariable Long userId,
            @Valid @RequestBody UserUpdateRequest request
    ){
        return ResponseEntity.ok(userService.update(userId, request));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long userId
    ){
        userService.delete(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
