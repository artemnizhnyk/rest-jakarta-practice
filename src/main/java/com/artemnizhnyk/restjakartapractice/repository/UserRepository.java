package com.artemnizhnyk.restjakartapractice.repository;

import com.artemnizhnyk.restjakartapractice.domain.model.User;

public interface UserRepository {

    User getUserById(Long id);
}
