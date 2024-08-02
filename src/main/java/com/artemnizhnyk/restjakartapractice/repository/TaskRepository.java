package com.artemnizhnyk.restjakartapractice.repository;

import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.domain.model.task.Task;

import java.util.List;

public interface TaskRepository {
    Task getTaskById();

    List<Task> getTasksByUser(User userById);

    Task createTask(Task task);

    Task updateTask(Task task);

    boolean deleteTask(Task task);
}
