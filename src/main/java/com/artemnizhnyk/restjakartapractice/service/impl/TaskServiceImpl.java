package com.artemnizhnyk.restjakartapractice.service.impl;

import com.artemnizhnyk.restjakartapractice.domain.model.Task;
import com.artemnizhnyk.restjakartapractice.service.TaskService;
import com.artemnizhnyk.restjakartapractice.web.dto.TaskDto;

import java.util.List;

public class TaskServiceImpl implements TaskService {

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
    public Task updateTask(TaskDto taskDto) {
        return null;
    }

    @Override
    public boolean deleteTaskById(Long id) {
        return false;
    }
}
