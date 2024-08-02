package com.artemnizhnyk.restjakartapractice.service.impl;

import com.artemnizhnyk.restjakartapractice.domain.model.task.Status;
import com.artemnizhnyk.restjakartapractice.domain.model.task.Task;
import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.repository.TaskRepository;
import com.artemnizhnyk.restjakartapractice.service.TaskService;
import com.artemnizhnyk.restjakartapractice.service.UserService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class TaskServiceImpl implements TaskService {

    @Inject
    private TaskRepository taskRepository;
    @Inject
    private UserService userService;

    @Override
    public Task getTaskById(final Long id) {
        return taskRepository.getTaskById(id);
    }

    @Override
    public List<Task> getTasksByUserId(final Long userId) {
        User userById = userService.getUserById(userId);
        return taskRepository.getTasksByUser(userById);
    }

    @Override
    public Task createTask(final Long userId, final Task task) {
        if (task.getStatus() == null) {
            task.setStatus(Status.IN_PROGRESS);
        }
        User user = userService.getUserById(userId);
        task.setUser(user);

        return taskRepository.createTask(task);
    }

    @Override
    public Task updateTask(final Task task) {
        Task obtainedTask = getTaskById(task.getId());
        if (Objects.isNull(obtainedTask)) {
            throw new RuntimeException();
        }
        return taskRepository.updateTask(task);
    }

    @Override
    public boolean deleteTaskById(final Long id) {
        Task task = getTaskById(id);
        if (Objects.isNull(task)) {
            throw new RuntimeException();
        }
        return taskRepository.deleteTask(task);
    }
}
