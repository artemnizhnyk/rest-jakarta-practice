package com.artemnizhnyk.restjakartapractice.web.rest.controller;

import com.artemnizhnyk.restjakartapractice.domain.model.task.Task;
import com.artemnizhnyk.restjakartapractice.domain.model.user.User;
import com.artemnizhnyk.restjakartapractice.service.TaskService;
import com.artemnizhnyk.restjakartapractice.service.UserService;
import com.artemnizhnyk.restjakartapractice.service.mapper.TaskMapper;
import com.artemnizhnyk.restjakartapractice.service.mapper.UserMapper;
import com.artemnizhnyk.restjakartapractice.web.dto.AnswerDto;
import com.artemnizhnyk.restjakartapractice.web.dto.TaskDto;
import com.artemnizhnyk.restjakartapractice.web.dto.UserDto;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.SecurityContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@RolesAllowed("ADMIN")
@Named
@RequestScoped
@Path("/v1/users")
public class UserRestControllerV1 {
    @Inject
    private UserService userService;
    @Inject
    private TaskService taskService;
    @Inject
    private TaskMapper taskMapper;
    @Inject
    private UserMapper userMapper;
    @Inject
    private SecurityContext securityContext;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDto getUserById(@PathParam("id") final Long id) {
        User userById = userService.getUserById(id);
        return userMapper.toDto(userById);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserDto getUserByUsername(@QueryParam("username") final String username) {
        User userByUsername = userService.getUserByUsername(username);
        return userMapper.toDto(userByUsername);
    }

    @GET
    @Path("/{id}/tasks")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TaskDto> getTasksByUserId(@PathParam("id") final Long userId) {
        List<Task> tasksByUserId = taskService.getTasksByUserId(userId);
        return tasksByUserId.stream().map(taskMapper::toDto).toList();
    }

    @POST
    @Path("/{id}/tasks")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TaskDto createTask(@PathParam("id") final Long userId,
                              final TaskDto taskDto) {
        Task createdTask = taskService.createTask(userId, taskMapper.toEntity(taskDto));
        return taskMapper.toDto(createdTask);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserDto updateUser(final UserDto userDto) {
        User updatedUser = userService.updateUser(userMapper.toEntity(userDto));
        return userMapper.toDto(updatedUser);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AnswerDto deleteUser(@PathParam("id") final Long id) {
        boolean isDeleted = userService.deleteUserById(id);
        return AnswerDto.makeDefault(isDeleted);
    }
}
