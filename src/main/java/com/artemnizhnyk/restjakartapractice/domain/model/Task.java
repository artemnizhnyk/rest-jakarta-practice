package com.artemnizhnyk.restjakartapractice.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "tasks")
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String description;
    @Enumerated(value = EnumType.STRING)
    @Column(name="task_status")
    private TaskStatus taskStatus;
    @Column(name="expires_at", nullable = false)
    private LocalDateTime expiresAt;
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private User user;
}
