package com.artemnizhnyk.restjakartapractice.service.impl;

import com.artemnizhnyk.restjakartapractice.domain.model.Task;
import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.repository.UserRepository;
import com.artemnizhnyk.restjakartapractice.service.UserService;
import com.artemnizhnyk.restjakartapractice.web.dto.TaskDto;
import com.artemnizhnyk.restjakartapractice.web.dto.UserDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Override
    public User getUserById(final Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public boolean deleteUserById(Long id) {
        return false;
    }


}
