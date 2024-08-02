package com.artemnizhnyk.restjakartapractice.service.impl;

import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.repository.UserRepository;
import com.artemnizhnyk.restjakartapractice.service.UserService;
import com.artemnizhnyk.restjakartapractice.web.dto.UserDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Objects;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Override
    public User getUserById(final Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User createUser(final User user) {
        return userRepository.createUser(user);
    }

    @Override
    public User updateUser(final User user) {
        User userById = getUserById(user.getId());
        if (Objects.isNull(userById)) {
            throw new RuntimeException();
        }
        return userRepository.updateUser(user);
    }

    @Override
    public boolean deleteUserById(Long id) {
        User userById = getUserById(id);
        if (Objects.isNull(userById)) {
            throw new RuntimeException();
        }
        return userRepository.deleteUser(userById);
    }


}
