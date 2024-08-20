package com.artemnizhnyk.restjakartapractice.web.dto;

import com.artemnizhnyk.restjakartapractice.domain.model.task.Status;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Data
public class TaskDto {

    private Long id;
    private String name;
    private String description;
    private Status status;
    private LocalDateTime expiresAt;
}
