package com.artemnizhnyk.restjakartapractice.web.rest.controller;

import com.artemnizhnyk.restjakartapractice.domain.exception.ExceptionBody;
import com.artemnizhnyk.restjakartapractice.domain.exception.ResourceNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler {

    @Provider
    public static class ResourceNotFoundExceptionMapper implements ExceptionMapper<ResourceNotFoundException> {
        @Override
        public Response toResponse(ResourceNotFoundException exception) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ExceptionBody(exception.getMessage()))
                    .build();
        }
    }
}
