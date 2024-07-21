package com.artemnizhnyk.restjakartapractice.service;

import com.artemnizhnyk.restjakartapractice.domain.model.Task;
import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.web.dto.TaskDto;

import java.util.List;

public interface UserService {

    User getUserById(Long id);

    List<Task> getTasksByUserId(Long id);

    Task createTask(TaskDto taskDto);

    User updateUser(TaskDto taskDto);

    boolean deleteUser();
}
