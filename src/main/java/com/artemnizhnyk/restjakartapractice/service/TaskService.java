package com.artemnizhnyk.restjakartapractice.service;

import com.artemnizhnyk.restjakartapractice.domain.model.task.Task;

import java.util.List;

public interface TaskService {

    Task getTaskById(final Long id);

    Task getTaskByName(String username);

    List<Task> getTasksByUserId(final Long userId);

    Task createTask(final Long userId, final Task task);

    Task updateTask(final Task task);

    boolean deleteTaskById(final Long id);
}
