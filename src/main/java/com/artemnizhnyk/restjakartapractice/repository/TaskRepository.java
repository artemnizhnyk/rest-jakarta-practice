package com.artemnizhnyk.restjakartapractice.repository;

import com.artemnizhnyk.restjakartapractice.domain.model.user.User;
import com.artemnizhnyk.restjakartapractice.domain.model.task.Task;

import java.util.List;

public interface TaskRepository {

    Task getTaskById(Long id);

    Task getTaskByName(String name);

    List<Task> getTasksByUser(User user);

    Task createTask(Task transientTask);

    Task updateTask(Task task);

    boolean deleteTask(Task task);
}
