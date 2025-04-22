
package com.example.taskmanager.service;

import com.example.taskmanager.dto.UserDTO;
import com.example.taskmanager.entity.User;
import com.example.taskmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
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

    public Page<User> getFilteredUsers(String firstName, String lastName, Pageable pageable) {
        List<User> all = userRepository.findAll();
        return new PageImpl<>(all.stream()
                .filter(u -> firstName == null || u.getFirstName().toLowerCase().contains(firstName.toLowerCase()))
                .filter(u -> lastName == null || u.getLastName().toLowerCase().contains(lastName.toLowerCase()))
                .toList(), pageable, all.size());
    }
}