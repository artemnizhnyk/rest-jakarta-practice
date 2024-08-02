package com.artemnizhnyk.restjakartapractice.service.impl;

import com.artemnizhnyk.restjakartapractice.domain.model.Task;
import com.artemnizhnyk.restjakartapractice.repository.TaskRepository;
import com.artemnizhnyk.restjakartapractice.service.TaskService;
import com.artemnizhnyk.restjakartapractice.web.dto.TaskDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TaskServiceImpl implements TaskService {

    @Inject
    private TaskRepository taskRepository;

    @Override
    public Task getTaskById(Long id) {
        return null;
    }

    @Override
    public List<Task> getTasksByUserId(Long userId) {
        return null;
    }

    @Override
    public Task createTask(Long userId, TaskDto taskDto) {
        return null;
    }

    @Override
    public Task updateTask(Task task) {
        return null;
    }

    @Override
    public boolean deleteTaskById(Long id) {
        return false;
    }
}
