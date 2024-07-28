package com.artemnizhnyk.restjakartapractice.web.rest.controller;

import com.artemnizhnyk.restjakartapractice.domain.model.Task;
import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.service.UserService;
import com.artemnizhnyk.restjakartapractice.service.mapper.TaskMapper;
import com.artemnizhnyk.restjakartapractice.web.dto.AnswerDto;
import com.artemnizhnyk.restjakartapractice.web.dto.TaskDto;
import com.artemnizhnyk.restjakartapractice.web.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("v1")
public class UserRestControllerV1 {
    @Inject
    private UserService userService;
    @Inject
    private TaskMapper taskMapper;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GET
    @Path("users/{id}")
    @Produces(MediaType.APPLICATION_JSON)
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

    @GET
    @Path("users/{id}/tasks")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TaskDto> getTasksByUserId(@PathParam("id") final Long userId) {
        List<Task> tasksByUserId = userService.getTasksByUserId(userId);

        return tasksByUserId.stream().map(taskMapper::toDto).toList();
    }

    public TaskDto createTask() {
        return null;
    }

    public UserDto updateUser() {
        return null;
    }

    public AnswerDto deleteUser() {
        return null;
    }
}
