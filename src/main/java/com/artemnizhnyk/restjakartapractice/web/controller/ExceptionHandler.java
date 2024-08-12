package com.artemnizhnyk.restjakartapractice.web.controller;

import com.artemnizhnyk.restjakartapractice.domain.exception.ExceptionBody;
import com.artemnizhnyk.restjakartapractice.domain.exception.ResourceNotFoundException;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.ForbiddenException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;
import java.util.stream.Collectors;

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

    @Provider
    public static class ResourceMappingExceptionMapper implements ExceptionMapper<Exception> {
        @Override
        public Response toResponse(Exception exception) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ExceptionBody(exception.getMessage()))
                    .build();
        }
    }

    @Provider
    public static class IllegalStateExceptionMapper implements ExceptionMapper<IllegalStateException> {
        @Override
        public Response toResponse(IllegalStateException exception) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ExceptionBody(exception.getMessage()))
                    .build();
        }
    }

    @Provider
    public static class AccessDeniedExceptionMapper implements ExceptionMapper<ForbiddenException> {
        @Override
        public Response toResponse(ForbiddenException exception) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity(new ExceptionBody("Access denied"))
                    .build();
        }
    }

    @Provider
    public static class AuthenticationExceptionMapper implements ExceptionMapper<jakarta.ws.rs.NotAuthorizedException> {
        @Override
        public Response toResponse(jakarta.ws.rs.NotAuthorizedException exception) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ExceptionBody("Authentication failed"))
                    .build();
        }
    }

    @Provider
    public static class MethodArgumentNotValidExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
        @Override
        public Response toResponse(ConstraintViolationException exception) {
            ExceptionBody exceptionBody = new ExceptionBody("Validation failed");
            Map<String, String> errors = exception.getConstraintViolations().stream()
                    .collect(Collectors.toMap(
                            violation -> violation.getPropertyPath().toString(),
                            violation -> violation.getMessage()));
            exceptionBody.setErrors(errors);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(exceptionBody)
                    .build();
        }
    }

    @Provider
    public static class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
        @Override
        public Response toResponse(ConstraintViolationException exception) {
            ExceptionBody exceptionBody = new ExceptionBody("Validation failed");
            Map<String, String> errors = exception.getConstraintViolations().stream()
                    .collect(Collectors.toMap(
                            violation -> violation.getPropertyPath().toString(),
                            violation -> violation.getMessage()));
            exceptionBody.setErrors(errors);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(exceptionBody)
                    .build();
        }
    }

    @Provider
    public static class GenericExceptionMapper implements ExceptionMapper<Exception> {
        @Override
        public Response toResponse(Exception exception) {
            exception.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ExceptionBody("Internal error"))
                    .build();
        }
    }

}
