
package com.example.taskmanager.controller;

import com.example.taskmanager.dto.TaskDTO;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public Task create(@RequestBody @Valid TaskDTO dto) {
        return taskService.createTask(dto);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody @Valid TaskDTO dto) {
        return taskService.updateTask(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @GetMapping
    public List<Task> all() {
        return taskService.getAllTasks();
    }
}
