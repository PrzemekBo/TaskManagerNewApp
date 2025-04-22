
package com.example.taskmanager.service;

import com.example.taskmanager.dto.UserDTO;
import com.example.taskmanager.entity.User;
import com.example.taskmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(UserDTO dto) {
        User user = User.builder()
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .email(dto.email())
                .build();
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
