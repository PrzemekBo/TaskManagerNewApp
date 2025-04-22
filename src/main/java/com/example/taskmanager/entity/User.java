
package com.example.taskmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @ManyToMany(mappedBy = "assignedUsers")
    private Set<Task> tasks = new HashSet<>();
}
