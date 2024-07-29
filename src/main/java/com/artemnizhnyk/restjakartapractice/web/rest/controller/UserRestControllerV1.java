package com.artemnizhnyk.restjakartapractice.web.rest.controller;

import com.artemnizhnyk.restjakartapractice.domain.model.Task;
import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.service.UserService;
import com.artemnizhnyk.restjakartapractice.service.mapper.TaskMapper;
import com.artemnizhnyk.restjakartapractice.service.mapper.UserMapper;
import com.artemnizhnyk.restjakartapractice.web.dto.AnswerDto;
import com.artemnizhnyk.restjakartapractice.web.dto.TaskDto;
import com.artemnizhnyk.restjakartapractice.web.dto.UserDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("v1/users/")
public class UserRestControllerV1 {
    @Inject
    private UserService userService;
    @Inject
    private TaskService taskService;
    @Inject
    private TaskMapper taskMapper;
    @Inject
    private UserMapper userMapper;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDto getUserById(@PathParam("id") final Long id) {
        User userById = userService.getUserById(id);
        return userMapper.toDto(userById);
    }

    @GET
    @Path("{id}/tasks")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TaskDto> getTasksByUserId(@PathParam("id") final Long userId) {
        List<Task> tasksByUserId = userService.getTasksByUserId(userId);

        return tasksByUserId.stream().map(taskMapper::toDto).toList();
    }

    @POST
    @Path("/{id}/tasks")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TaskDto createTask(@PathParam("id") final Long userId,
                             final TaskDto taskDto) {
        return taskService.createTask(userId, taskDto);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserDto updateUser(final UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AnswerDto deleteUser(final UserDto userDto) {
        return AnswerDto.makeDefault(true);
    }
}
