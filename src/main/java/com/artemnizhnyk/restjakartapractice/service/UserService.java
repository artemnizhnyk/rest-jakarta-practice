package com.artemnizhnyk.restjakartapractice.service;

import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.web.dto.UserDto;

public interface UserService {

    User getUserById(Long id);

    User updateUser(UserDto userDto);

    boolean deleteUserById(Long id);
}
