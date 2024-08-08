package com.artemnizhnyk.restjakartapractice.service.impl;

import com.artemnizhnyk.restjakartapractice.domain.exception.ResourceNotFoundException;
import com.artemnizhnyk.restjakartapractice.domain.model.task.Status;
import com.artemnizhnyk.restjakartapractice.domain.model.task.Task;
import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.repository.TaskRepository;
import com.artemnizhnyk.restjakartapractice.service.TaskService;
import com.artemnizhnyk.restjakartapractice.service.UserService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
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
        Task taskById = taskRepository.getTaskById(id);
        if (Objects.isNull(taskById)) {
            throw new ResourceNotFoundException(String.format("Task with id: %d, wasn't found", id));
        }
        return taskById;
    }

    @Override
    public List<Task> getTasksByUserId(final Long userId) {
        User userById = userService.getUserById(userId);
        if (Objects.isNull(userById)) {
           return new ArrayList<>();
        }
        return taskRepository.getTasksByUser(userById);
    }

    @Override
    public Task createTask(final Long userId, final Task task) {
        if (task.getStatus() == null) {
            task.setStatus(Status.IN_PROGRESS);
        }
        User user = userService.getUserById(userId);
        if (Objects.isNull(user)) {
            throw new RuntimeException();
        }
        task.setUser(user);
        return taskRepository.createTask(task);
    }

    @Override
    public Task updateTask(final Task task) {
        Task obtainedTask = getTaskById(task.getId());
        if (Objects.isNull(obtainedTask)) {
            throw new ResourceNotFoundException(String.format("Task with id: %d, wasn't found", task.getId()));
        }
        return taskRepository.updateTask(task);
    }

    @Override
    public boolean deleteTaskById(final Long id) {
        Task task = getTaskById(id);
        if (Objects.isNull(task)) {
            return false;
        }
        return taskRepository.deleteTask(task);
    }
}
