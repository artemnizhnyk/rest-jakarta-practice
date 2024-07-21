package com.artemnizhnyk.restjakartapractice.web.rest.controller;

import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.service.UserService;
import com.artemnizhnyk.restjakartapractice.web.dto.AnswerDto;
import com.artemnizhnyk.restjakartapractice.web.dto.TaskDto;
import com.artemnizhnyk.restjakartapractice.web.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/v1")
public class UserRestControllerV1 {
    @Inject
    private UserService userService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GET
    @Path("/users/{id}")
    @Produces("application/json")
    public UserDto getUserById(@PathParam("id") final Long id) {
        User userById = userService.getUserById(id);
        UserDto userDto = UserDto.builder()
                .id(userById.getId())
                .username(userById.getUsername())
                .password(userById.getPassword())
                .tasks(new ArrayList<>())
                .build();
        return userDto;
    }

    List<TaskDto> getTasksByUserId() {
        return new ArrayList<>();
    }

    TaskDto createTask() {
        return null;
    }

    UserDto updateUser() {
        return null;
    }

    AnswerDto deleteUser() {
        return null;
    }
}
