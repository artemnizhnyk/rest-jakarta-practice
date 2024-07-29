package com.artemnizhnyk.restjakartapractice.service.mapper;

import com.artemnizhnyk.restjakartapractice.domain.model.Task;
import com.artemnizhnyk.restjakartapractice.web.dto.TaskDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta-cdi")
public interface TaskMapper extends Mappable<Task, TaskDto>{

}
