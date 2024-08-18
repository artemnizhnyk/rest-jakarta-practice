package com.artemnizhnyk.restjakartapractice.web.rest.controller;


import com.artemnizhnyk.restjakartapractice.domain.model.user.User;
import com.artemnizhnyk.restjakartapractice.service.AuthService;
import com.artemnizhnyk.restjakartapractice.service.UserService;
import com.artemnizhnyk.restjakartapractice.service.mapper.UserMapper;
import com.artemnizhnyk.restjakartapractice.web.dto.UserDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/auth")
public class AuthControllerV1 {

    private AuthService authService;
    @Inject
    private UserService userService;
    @Inject
    private UserMapper userMapper;

    @POST
    @Path("/login")
    public void login(
//            JwtRequest loginRequest
    ) {
//        return authService.login(loginRequest);
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserDto register(final UserDto userDto) {
        User user = userService.createUser(userMapper.toEntity(userDto));
        return userMapper.toDto(user);
    }

    @POST
    @Path("/refresh")
    public void refresh(final String refreshToken) {
//        return authService.refresh(refreshToken);
    }
}
