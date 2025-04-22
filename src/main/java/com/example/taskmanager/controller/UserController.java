
package com.example.taskmanager.controller;

import com.example.taskmanager.dto.UserDTO;
import com.example.taskmanager.entity.User;
import com.example.taskmanager.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User create(@RequestBody @Valid UserDTO dto) {
        return userService.createUser(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping
    public List<User> all() {
        return userService.getAllUsers();
    }
}
