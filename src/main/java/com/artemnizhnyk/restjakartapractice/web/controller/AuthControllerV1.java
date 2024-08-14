package com.artemnizhnyk.restjakartapractice.web.controller;


import com.artemnizhnyk.restjakartapractice.service.UserService;
import com.artemnizhnyk.restjakartapractice.service.mapper.UserMapper;
import com.artemnizhnyk.restjakartapractice.web.dto.UserDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/v1/auth")
public class AuthControllerV1 {

//    private AuthService authService;
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
    public void register(final UserDto userDto) {
//        return userService.createUser(userMapper.toEntity(userDto));
    }

    @POST
    @Path("/refresh")
    public void refresh(final String refreshToken) {
//        return authService.refresh(refreshToken);
    }
}
