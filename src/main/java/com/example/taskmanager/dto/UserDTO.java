
package com.example.taskmanager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(
    @NotBlank String firstName,
    @NotBlank String lastName,
    @NotBlank @Email String email
) {}
