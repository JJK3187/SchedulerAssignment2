package com.schedule2.user.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserGetResponse {

    private final Long id;
    private final String username;
    private final String email;
    private final LocalDateTime createdAt;


    public UserGetResponse(Long id, String username, String email, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
    }
}
