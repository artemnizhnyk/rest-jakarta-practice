package com.artemnizhnyk.restjakartapractice.web.controller;

import com.artemnizhnyk.restjakartapractice.domain.model.task.Task;
import com.artemnizhnyk.restjakartapractice.service.TaskService;
import com.artemnizhnyk.restjakartapractice.service.mapper.TaskMapper;
import com.artemnizhnyk.restjakartapractice.web.dto.AnswerDto;
import com.artemnizhnyk.restjakartapractice.web.dto.TaskDto;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Named
@RequestScoped
@Path("/v1/tasks")
public class TaskRestControllerV1 {

    @Inject
    private TaskService taskService;
    @Inject
    private TaskMapper taskMapper;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TaskDto getTaskById(@PathParam("id") final Long id) {
        Task taskById = taskService.getTaskById(id);
        return taskMapper.toDto(taskById);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TaskDto updateTask(final TaskDto taskDto) {
        Task updatedUser = taskService.updateTask(taskMapper.toEntity(taskDto));
        return taskMapper.toDto(updatedUser);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AnswerDto deleteTask(@PathParam("id") final Long id) {
        boolean isDeleted = taskService.deleteTaskById(id);
        return AnswerDto.makeDefault(isDeleted);
    }
}
