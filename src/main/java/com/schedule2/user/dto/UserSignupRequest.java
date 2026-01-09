package com.schedule2.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserSignupRequest {

    @NotBlank @Size(max = 4)
    private String username;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(min = 8, max = 20)
    private String password;
}
