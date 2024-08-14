package com.artemnizhnyk.restjakartapractice.service.impl;

import com.artemnizhnyk.restjakartapractice.domain.exception.ResourceNotFoundException;
import com.artemnizhnyk.restjakartapractice.domain.model.user.User;
import com.artemnizhnyk.restjakartapractice.repository.UserRepository;
import com.artemnizhnyk.restjakartapractice.service.UserService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.Objects;

@Named
@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Override
    public User getUserById(final Long id) {
        User userById = userRepository.getUserById(id);
        if (Objects.isNull(userById)) {
            throw new ResourceNotFoundException(String.format("User with id: %d, wasn't found", id));
        }
        return userById;
    }

    @Override
    public User getUserByUsername(final String username) {
        User userByUsername = userRepository.getUserByUsername(username);
        if (Objects.isNull(userByUsername)) {
            throw new ResourceNotFoundException(String.format("User with username: %s, wasn't found", username));
        }
        return userByUsername;
    }

    @Override
    public User createUser(final User user) {
        return userRepository.createUser(user);
    }

    @Override
    public User updateUser(final User user) {
        User obtainedUser = getUserById(user.getId());
        if (Objects.isNull(obtainedUser)) {
            throw new ResourceNotFoundException(String.format("User with id: %d, wasn't found", user.getId()));
        }
        return userRepository.updateUser(user);
    }

    @Override
    public boolean deleteUserById(Long id) {
        User userById = getUserById(id);
        if (Objects.isNull(userById)) {
            return false;
        }
        return userRepository.deleteUser(userById);
    }
}
