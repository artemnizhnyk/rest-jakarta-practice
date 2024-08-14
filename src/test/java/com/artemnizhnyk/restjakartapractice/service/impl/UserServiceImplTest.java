package com.artemnizhnyk.restjakartapractice.service.impl;

import com.artemnizhnyk.restjakartapractice.domain.model.user.User;
import com.artemnizhnyk.restjakartapractice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach


    @Test
    void getUserById_shouldReturnUserWithPassedId() {
        //given
        User user = new User(1L, "Artem", "12345", new ArrayList<>());
        long passedUserId = 1;

        //when
        when(userRepository.getUserById(passedUserId)).thenReturn(user);
        User userById = userService.getUserById(passedUserId);

        //then
        assertThat(userById).isEqualTo(user);
    }
}