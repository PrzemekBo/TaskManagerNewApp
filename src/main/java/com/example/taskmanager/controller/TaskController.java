
package com.example.taskmanager.controller;

import com.example.taskmanager.dto.StatusUpdateDTO;
import com.example.taskmanager.dto.TaskDTO;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/{id}/status")
    public Task updateStatus(@PathVariable Long id, @RequestBody StatusUpdateDTO dto) {
        return taskService.updateStatus(id, dto.status());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @GetMapping
    public Page<Task> all(@RequestParam(required = false) String title,
                          @RequestParam(required = false) String status,
                          Pageable pageable) {
        return taskService.getFilteredTasks(title, status, pageable);
    }
}