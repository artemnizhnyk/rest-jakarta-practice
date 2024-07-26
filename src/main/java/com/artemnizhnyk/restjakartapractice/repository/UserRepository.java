package com.artemnizhnyk.restjakartapractice.repository;

import com.artemnizhnyk.restjakartapractice.domain.model.Task;
import com.artemnizhnyk.restjakartapractice.domain.model.User;

import java.util.List;

public interface UserRepository {

    User getUserById(Long id);

    List<Task> tasksByUserId(Long userId);
}
