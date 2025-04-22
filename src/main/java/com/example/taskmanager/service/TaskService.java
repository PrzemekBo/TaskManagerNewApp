
package com.example.taskmanager.service;

import com.example.taskmanager.dto.TaskDTO;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.entity.User;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public Task createTask(TaskDTO dto) {
        Task task = Task.builder()
                .title(dto.title())
                .description(dto.description())
                .status(dto.status())
                .dueDate(dto.dueDate())
                .assignedUsers(new HashSet<>(userRepository.findAllById(dto.userIds())))
                .build();
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, TaskDTO dto) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setStatus(dto.status());
        task.setDueDate(dto.dueDate());
        task.setAssignedUsers(new HashSet<>(userRepository.findAllById(dto.userIds())));
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
