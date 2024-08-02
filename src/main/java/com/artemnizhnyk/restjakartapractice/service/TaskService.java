package com.artemnizhnyk.restjakartapractice.service;

import com.artemnizhnyk.restjakartapractice.domain.model.Task;
import com.artemnizhnyk.restjakartapractice.web.dto.TaskDto;

import java.util.List;

public interface TaskService {

    Task getTaskById(final Long id);

    List<Task> getTasksByUserId(final Long userId);

    Task createTask(final Long userId, final TaskDto taskDto);

    Task updateTask(final Task task);

    boolean deleteTaskById(final Long id);
}
