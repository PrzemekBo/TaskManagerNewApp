
package com.example.taskmanager.dto;

import com.example.taskmanager.entity.TaskStatus;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Set;

public record TaskDTO(
    @NotBlank String title,
    String description,
    TaskStatus status,
    LocalDate dueDate,
    Set<Long> userIds
) {}
