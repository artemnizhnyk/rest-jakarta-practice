package com.artemnizhnyk.restjakartapractice.domain.model.task;

import com.artemnizhnyk.restjakartapractice.domain.model.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table(name = "tasks")
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Builder.Default
//    private UUID uuid = UUID.randomUUID();
    @Column(unique = true, nullable = false)
    private String name;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    @Column(name="expires_at", nullable = false)
    private LocalDateTime expiresAt;
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private User user;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(name, task.name) && Objects.equals(description, task.description) && status == task.status && Objects.equals(expiresAt, task.expiresAt) && Objects.equals(user, task.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, status, expiresAt, user);
    }
}
