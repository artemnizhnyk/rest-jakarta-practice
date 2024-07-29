package com.artemnizhnyk.restjakartapractice.web.dto;

import com.artemnizhnyk.restjakartapractice.domain.model.Task;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Data
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private List<Task> tasks;
}