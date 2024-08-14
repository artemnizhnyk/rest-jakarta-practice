package com.artemnizhnyk.restjakartapractice.service.mapper;

import com.artemnizhnyk.restjakartapractice.domain.model.user.User;
import com.artemnizhnyk.restjakartapractice.web.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta-cdi")
public interface UserMapper extends Mappable<User, UserDto>{
}
