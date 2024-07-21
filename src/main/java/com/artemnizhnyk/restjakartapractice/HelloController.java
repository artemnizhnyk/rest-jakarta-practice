package com.artemnizhnyk.restjakartapractice;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/hello-world")
public class HelloController
{
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}