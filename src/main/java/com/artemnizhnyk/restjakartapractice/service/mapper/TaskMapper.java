package com.artemnizhnyk.restjakartapractice.service.mapper;

import com.artemnizhnyk.restjakartapractice.domain.model.Task;
import com.artemnizhnyk.restjakartapractice.domain.model.User;
import com.artemnizhnyk.restjakartapractice.web.dto.TaskDto;
import com.artemnizhnyk.restjakartapractice.web.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface TaskMapper extends Mappable<Task, TaskDto>{
}
