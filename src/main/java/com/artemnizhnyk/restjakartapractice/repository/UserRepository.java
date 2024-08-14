package com.artemnizhnyk.restjakartapractice.repository;

import com.artemnizhnyk.restjakartapractice.domain.model.user.User;

public interface UserRepository {

    User getUserById(Long id);

    User getUserByUsername(String username);

    User createUser(User transientUser);

    User updateUser(User user);

    boolean deleteUser(User User);
}
